package org.example.prueba.dto;


public record UserResponseDTO(
        Long id,
        String name,
        String lastName,
        String phoneNumber,
        String email
) {}

