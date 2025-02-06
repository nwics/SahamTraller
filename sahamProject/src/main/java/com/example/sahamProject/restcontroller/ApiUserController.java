package com.example.sahamProject.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.model.MUser;
import com.example.sahamProject.service.UserService;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    private final UserService userService;

    public ApiUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/valid/email")
    public ResponseEntity<?> findValidEmail(@RequestParam String email) {
        String response = this.userService.getValidasiEmail(email);

        if (response.equals("found")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/email")
    public ResponseEntity<?> findUserByEmail(@RequestParam String email) {
        MUser user = this.userService.getUserByEmail(email);

        if (user.getId() != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not found", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/email-password")
    public ResponseEntity<?> addUserByEmailPassword(@RequestParam String email, @RequestParam String password) {
        MUser tempUser = new MUser();
        tempUser.setEmail(email);
        tempUser.setPassword(password);
        MUser response = this.userService.addNewUser(tempUser);

        if (response.getId().equals(null)) {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/add/userdata")
    public ResponseEntity<?> addUser(@RequestBody MUser user) {
        // MUser response = this.userService.addNewUser(user);

        // if (response.getId() != null) {
        // return ResponseEntity.ok(response);
        // } else {
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        // }

        String response = this.userService.addUserData(user);
        if (response == "success") {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/check-session")
    public ResponseEntity<?> checkSession(@RequestHeader("Authorization") String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        return ResponseEntity.ok("Session is valid");
    }

}
