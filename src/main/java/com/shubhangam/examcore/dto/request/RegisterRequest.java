package com.shubhangam.examcore.dto.request;

import com.shubhangam.examcore.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    Role role;
    String email;
    String name;
    String password;
}
