package com.example.ingressacademytask.dto;

import com.example.ingressacademytask.enums.UserType;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    @NotBlank(message = "Name cannot be empty")
    String name;
    @Email(message = "Email format is not correct")
    String email;
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d{8,})[a-zA-Z\\d]+$", message = "minimum 8 character and 1 letter")
    String password;
    @Min(18)
    int age;
    UserType userType;
}
