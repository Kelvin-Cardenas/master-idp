package org.example.prueba.members.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MembersRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank(message = "El documento es obligatorio")
    @Pattern(regexp = "^\\d{8}$", message = "El DNI debe tener exactamente 8 dígitos")
    private String documentNumber;

    @NotBlank(message = "El género es obligatorio")
    @Pattern(regexp = "M|F|OTHER", message = "Valores permitidos: M, F, OTHER")
    private String gender;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser pasada")
    private LocalDate birthday;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "Debe ser un número válido de 9 dígitos")
    private String phoneNumber;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    private String email;

    @Size(max = 150, message = "Máximo 150 caracteres")
    private String address;

    @PastOrPresent(message = "La fecha de conversión no puede ser futura")
    private LocalDate conversionDate;

    @PastOrPresent(message = "La fecha de bautismo no puede ser futura")
    private LocalDate baptismDate;

    @NotNull(message = "La iglesia es obligatoria")
    private Long churchId;



}
