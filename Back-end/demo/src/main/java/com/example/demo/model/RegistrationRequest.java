package com.example.demo.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "firstName should not be empty")
    @NotBlank(message = "firstName should not contain spaces")
    private String firstName;
    @NotEmpty(message = "lastName should not be empty")
    @NotBlank(message = "lastName should not contain spaces")
    private String lastName;
    @Email(message = "email is not well formatted")
    @NotEmpty(message = "email should not be empty")
    @NotBlank(message = "email should not contain spaces")
    private String email;
    @NotEmpty(message = "password should not be empty")
    @NotBlank(message = "password should not contain spaces")
    @Size(min = 8, message = "password should be 8 characters long minimum")
    private String password;
    @NotEmpty(message = "role should not be empty")
    @NotBlank(message = "role should not contain spaces")
    private String role;
}
