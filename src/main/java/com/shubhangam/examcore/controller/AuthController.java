package com.shubhangam.examcore.controller;

import com.shubhangam.examcore.dto.request.LoginRequest;
import com.shubhangam.examcore.dto.request.RegisterRequest;
import com.shubhangam.examcore.dto.response.AuthResponse;
import com.shubhangam.examcore.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        String message =  authService.register(request);
        return ResponseEntity.status(201).body(message);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){

        AuthResponse message = authService.login(request);
        return ResponseEntity.ok(message);
    }


}
