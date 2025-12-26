package org.example.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRequestDTO(
        @NotBlank
        String name,

        @NotBlank
        String lastName,

        @NotBlank
        @Pattern(regexp = "^9\\d{8}$")
        String phoneNumber,

        @NotBlank
        @Email
        String email
) {}

