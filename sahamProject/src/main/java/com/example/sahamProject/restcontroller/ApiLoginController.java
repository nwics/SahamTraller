package com.example.sahamProject.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.model.MUser;
import com.example.sahamProject.service.LoginService;

@RestController
@RequestMapping("/api/auth")
public class ApiLoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login-user")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        // String userLogin = this.loginService.validateEmailPassword(mUser);
        MUser user = new MUser();
        user.setEmail(email);
        user.setPassword(password);

        Map<String, Object> response = loginService.validateEmailPassword(user);

        if ("success".equals(response.get("status"))) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
