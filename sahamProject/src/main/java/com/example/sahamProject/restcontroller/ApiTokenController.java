package com.example.sahamProject.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.service.TokenService;

@RestController
@RequestMapping("/api/otp")
public class ApiTokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/get")
    public ResponseEntity<?> getOtp(@RequestParam String email) {
        String response = this.tokenService.generateOtp(email);
        if ("success".equals(response)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateOtp(@RequestParam String email, @RequestParam String otp) {
        String response = this.tokenService.validateOtp(email, otp);
        if ("success".equals(response)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/otp-request")
    public ResponseEntity<?> havingOtp(@RequestParam String email) {
        Long response = this.tokenService.getRemaining(email);
        if (response == null) {
            return new ResponseEntity<>("0", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
