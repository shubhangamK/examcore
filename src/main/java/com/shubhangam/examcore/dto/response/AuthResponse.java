package com.shubhangam.examcore.dto.response;

import com.shubhangam.examcore.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    Role role;
    String email;
    String token;
}
