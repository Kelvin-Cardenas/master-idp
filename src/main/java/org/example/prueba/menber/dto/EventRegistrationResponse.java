package org.example.prueba.menber.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EventRegistrationResponse {


    private Long id;

    // Evento
    private String eventName;
    private LocalDate eventDate;
    private String eventLocation;
    private BigDecimal eventCost;

    // Participante
    private String fullName;
    private String documentNumber;
    private String phone;
    private String email;

    // Iglesia
    private String memberRole;
    private String churchCampus;

    // Inscripción
    private String registrationCode;
    private String notes;

    // Pago
    private String paymentStatus;


}
