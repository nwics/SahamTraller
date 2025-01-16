package com.example.sahamProject.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sahamProject.dao.UserRepository;
import com.example.sahamProject.model.MUser;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> validateEmailPassword(@RequestBody MUser mUser) {
        // Map<String, String> listUser =
        // this.userRepository.findByEmailPasswordAndIsDeleteFalse(email, password);

        String email = mUser.getEmail();
        String password = mUser.getPassword();

        Map<String, String> errors = new HashMap<>();
        Map<String, Object> response = new HashMap<>();

        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Email wajib diisi");
        }
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "Password wajib diisi");
        }

        if (!errors.isEmpty()) {
            response.put("status", "error");
            response.put("errors", errors);
            return response;
        }

        List<MUser> users = userRepository.findByEmailAndIsDeleteFalse(email);

        if (users.isEmpty()) {
            errors.put("email", "Email tidak terdaftar");
        } else {

            MUser user = users.get(users.size() - 1);

            if (!user.getPassword().equals(password)) {
                errors.put("password", "Password tidak sesuai");
            } else {

                user.setLastLogin(LocalDateTime.now());
                userRepository.save(user);
            }
        }

        if (!errors.isEmpty()) {
            response.put("status", "error");
            response.put("errors", errors);
            return response;
        }

        response.put("status", "success");
        response.put("message", "Login berhasil");
        return response;
    }
}
