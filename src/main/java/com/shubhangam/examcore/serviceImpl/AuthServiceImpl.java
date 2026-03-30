package com.shubhangam.examcore.serviceImpl;

import com.shubhangam.examcore.dto.request.LoginRequest;
import com.shubhangam.examcore.dto.request.RegisterRequest;
import com.shubhangam.examcore.dto.response.AuthResponse;
import com.shubhangam.examcore.entity.User;
import com.shubhangam.examcore.security.JwtUtil;
import com.shubhangam.examcore.service.AuthService;
import com.shubhangam.examcore.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder ;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository ,  PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
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
        String token = jwtUtil.generateToken(user.getEmail() , user.getRole().name());
        return new AuthResponse( user.getRole(), user.getEmail(), token);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Optional<User> existingUser = userRepository.findByEmail(loginRequest.getEmail());
        if(existingUser.isEmpty()){
            throw new RuntimeException("No User exist");
        }
        User user = existingUser.get();

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Password does not match");
        }
        String token = jwtUtil.generateToken(user.getEmail() , user.getRole().name());
        return new AuthResponse( user.getRole() , user.getEmail(),token);
    }
}
