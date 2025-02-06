package com.example.sahamProject.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.model.MUser;
import com.example.sahamProject.service.LoginService;

// import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class ApiLoginController {

    @Autowired
    private LoginService loginService;
    // @Autowired
    // private AuthenticationManager authenticationManager;

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

    // @PostMapping("/login-user")
    // public ResponseEntity<Map<String, Object>> loginUser(@RequestBody
    // LoginRequest loginRequest) {
    // // String userLogin = this.loginService.validateEmailPassword(mUser);
    // String email = loginRequest.getEmail();
    // String password = loginRequest.getPassword();

    // MUser user = new MUser();
    // user.setEmail(email);
    // user.setPassword(password);

    // Map<String, Object> response = loginService.validateEmailPassword(user);

    // if ("success".equals(response.get("status"))) {
    // String token = generateToken(user);
    // response.put("token", token);
    // return new ResponseEntity<>(response, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    // }
    // }
    // @PostMapping("/login-user")
    // public ResponseEntity<String> loginUser(@RequestBody LoginRequest
    // loginRequest, HttpServletRequest request) {
    // if (loginRequest.getPassword() == null ||
    // loginRequest.getPassword().isEmpty()) {
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error : Password
    // tidak boleh kosong");
    // }
    // try {
    // Authentication authentication = authenticationManager.authenticate(
    // new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
    // loginRequest.getPassword()));

    // SecurityContextHolder.getContext().setAuthentication(authentication);
    // request.getSession().setAttribute("SPRING_SECURITY_CONTEXT",
    // SecurityContextHolder.getContext());

    // return ResponseEntity.ok("Login sukses!");
    // } catch (Exception e) {
    // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login gagal: " +
    // e.getMessage());
    // }
    // }

    // @Bean
    // public AuthenticationManager
    // authenticationManager(AuthenticationConfiguration
    // authenticationConfiguration)
    // throws Exception {
    // return authenticationConfiguration.getAuthenticationManager();
    // }

    // private String generateToken(MUser user) {
    // return "token-" + user.getEmail() + "-12345";

    // }

}

class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
