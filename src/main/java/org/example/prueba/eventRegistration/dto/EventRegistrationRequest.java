package org.example.prueba.eventRegistration.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EventRegistrationRequest {

    // Evento
    @NotBlank(message = "El nombre del evento es obligatorio")
    private String eventName;

    @NotNull(message = "La fecha del evento es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser hoy o futura")
    private LocalDate eventDate;

    @NotBlank(message = "La ubicación es obligatoria")
    private String eventLocation;

    @NotNull(message = "El costo es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El costo no puede ser negativo")
    private BigDecimal eventCost;

    // Participante
    @NotBlank(message = "El nombre completo es obligatorio")
    @Size(min = 3, max = 100)
    private String fullName;

    @NotBlank(message = "El documento es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "Debe ser un DNI válido de 8 dígitos")
    private String documentNumber;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "Debe ser un número válido de 9 dígitos")
    private String phone;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    private String email;

    // Iglesia
    @NotBlank(message = "El rol es obligatorio")
    private String memberRole;

    @NotBlank(message = "La sede es obligatoria")
    private String churchCampus;

    // Inscripción
    @NotBlank(message = "El código de registro es obligatorio")
    private String registrationCode;

    @Size(max = 500, message = "Máximo 500 caracteres")
    private String notes;

    // Pago
    @NotBlank(message = "El estado de pago es obligatorio")
    @Pattern(regexp = "PENDING|PAID|CANCELLED", message = "Estado inválido")
    private String paymentStatus;
}
