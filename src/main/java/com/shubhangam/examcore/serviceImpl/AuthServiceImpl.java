package com.shubhangam.examcore.serviceImpl;

import com.shubhangam.examcore.dto.request.LoginRequest;
import com.shubhangam.examcore.dto.request.RegisterRequest;
import com.shubhangam.examcore.dto.response.AuthResponse;
import com.shubhangam.examcore.entity.User;
import com.shubhangam.examcore.service.AuthService;
import com.shubhangam.examcore.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder ;

    public AuthServiceImpl(UserRepository userRepository ,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        String email = registerRequest.getEmail();
        Optional<User> existingUser = userRepository.findByEmail(email);
        if(existingUser.isPresent()){
            throw new RuntimeException("user already exist");
        }
        if (registerRequest.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        String hashedPassword =passwordEncoder.encode(registerRequest.getPassword());
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(hashedPassword)
                .role(registerRequest.getRole())
                .build();
        userRepository.save(user);
        return "user Register Successfully";
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        String token = "dummy-token_" + loginRequest.getEmail();
        Optional<User> existingUser = userRepository.findByEmail(loginRequest.getEmail());
        if(existingUser.isEmpty()){
            throw new RuntimeException("No User exist");
        }
        User user = existingUser.get();
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Password doesnot match");
        }
        return new AuthResponse( user.getRole() , user.getEmail(),token);
    }
}
