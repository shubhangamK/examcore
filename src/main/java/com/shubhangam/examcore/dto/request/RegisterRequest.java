package com.shubhangam.examcore.dto.request;

import com.shubhangam.examcore.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Name is Required")
    private String name;

    @NotBlank (message = "Email is Required")
    @Email(message = "Invalid Email Format")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min = 6 , message = "Password Must be at Least 6 characters")
    private String password;

    @NotNull(message = "Role is Required")
    private Role role;
}
