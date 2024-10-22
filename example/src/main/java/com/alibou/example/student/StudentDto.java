package com.alibou.example.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(@NotEmpty(message = "First name should not be empty")
                         String firstname,
                         @NotEmpty(message = "Last name should not be empty")
                         String lastname,
                         @Email
                         String email,
                         Integer schoolId
                         ) {
}
