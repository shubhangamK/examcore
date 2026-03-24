package com.shubhangam.examcore.controller;

import com.shubhangam.examcore.dto.request.LoginRequest;
import com.shubhangam.examcore.dto.request.RegisterRequest;
import com.shubhangam.examcore.dto.response.AuthResponse;
import com.shubhangam.examcore.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
       return authService.register(request);
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }


}
