package com.example.authService.controller;

import com.example.authService.model.User;
import com.example.authService.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserRegisterService userRegisterService;

    @Autowired
    PasswordEncoder passwordEncoder;

    // using this api to register the user into the system
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        //Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRegisterService.save(user);
        return ResponseEntity.ok("User successfully registered!");
    }

    @GetMapping("/users")
    public String getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "fetched user details succssfully";
    }

}
