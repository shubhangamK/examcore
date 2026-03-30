package com.shubhangam.examcore.service;

import com.shubhangam.examcore.dto.request.LoginRequest;
import com.shubhangam.examcore.dto.request.RegisterRequest;
import com.shubhangam.examcore.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}
