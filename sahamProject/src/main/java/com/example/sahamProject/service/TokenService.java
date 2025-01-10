package com.example.sahamProject.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.TokenRepository;
import com.example.sahamProject.dao.UserRepository;
import com.example.sahamProject.model.TToken;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class TokenService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    public String sendOtpEmail(String email, String otp) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Your OTP Code");
        helper.setText("YOUR OTP CODE IS : " + otp);

        mailSender.send(message);

        return "Success";
    }

    public String createOtp(String email) {
        String otp = String.format("%06d", new Random().nextInt(1000000));

        LocalDateTime expiredTime = LocalDateTime.now().plusMinutes(10L);

        TToken token = new TToken();

        try {
            sendOtpEmail(email, otp);
            token.setEmail(email);
            token.setExpiredOn(expiredTime);
            token.setToken(otp);
            token.setCreatedOn(LocalDateTime.now());
            Long preservedId = 123454321L;
            token.setCreatedBy(preservedId);
            token.setUsedFor("registration");

            this.tokenRepository.save(token);
            return "success";
        } catch (Exception e) {
            return "faill to send otp error " + e;
        }
    }

    public String validateOtp(String email, String otp) {
        List<TToken> tokenModel = this.tokenRepository.findByEmailAndIsExpiredFalse(email);

        TToken tempToken = tokenModel.get(0);

        if (tempToken.getToken().equals(otp) & tempToken.getExpiredOn().isAfter(LocalDateTime.now())) {
            tempToken.setIsExpired(true);
            this.tokenRepository.save(tempToken);
            return "success";
        } else if (tempToken.getToken().equals(otp) & tempToken.getExpiredOn().isBefore(LocalDateTime.now())) {
            tempToken.setIsExpired(false);
            this.tokenRepository.save(tempToken);
            return "expired";
        }
        return "fail";
    }

    public String generateOtp(String email) {
        List<TToken> temp = this.tokenRepository.findByEmailAndIsExpiredFalse(email);

        if (temp.size() > 0) {
            TToken currentToken = temp.get(0);

            if (currentToken.getEmail().equals(email)) {
                try {
                    String otp = String.format("%06d", new Random().nextInt(100000));
                    sendOtpEmail(email, otp);

                    if (LocalDateTime.now().isBefore(currentToken.getCreatedOn().plus(3L, ChronoUnit.MINUTES))) {
                        return "success";
                    } else {
                        currentToken.setToken(otp);
                        currentToken.setCreatedOn(LocalDateTime.now());
                        currentToken.setIsExpired(false);

                        currentToken.setCreatedOn(LocalDateTime.now());
                        this.tokenRepository.save(currentToken);
                        return "success";
                    }
                } catch (Exception e) {
                    return "fail " + e;
                }
            }
        }
        String response = createOtp(email);
        return response;
    }

    public Long getRemaining(String email) {
        try {
            List<TToken> temp = this.tokenRepository.findByEmailAndIsExpiredFalse(email);
            TToken tempToken = temp.get(0);
            if (tempToken.getCreatedOn().isAfter(LocalDateTime.now())) {
                tempToken.setIsExpired(true);
                this.tokenRepository.save(tempToken);
                return null;
            } else if (LocalDateTime.now().isBefore(tempToken.getCreatedOn().plus(3L, ChronoUnit.MINUTES))) {
                Duration duration = Duration.between(tempToken.getCreatedOn().plus(3L, ChronoUnit.MINUTES),
                        LocalDateTime.now());
                Long second = duration.getSeconds();
                second = Math.abs(second);
                return second;
            } else if (LocalDateTime.now().isAfter(tempToken.getCreatedOn().plus(3L, ChronoUnit.MINUTES))) {
                return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}
