package org.example.prueba.menber.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "event_registrations")
public class EventRegistration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos del evento
    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "event_cost")
    private java.math.BigDecimal eventCost;

    // Datos del participante
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    // Iglesia
    @Column(name = "member_role")
    private String memberRole;

    @Column(name = "church_campus")
    private String churchCampus;

    // Inscripción
    @Column(name = "registration_code")
    private String registrationCode;

    @Column(name = "notes")
    private String notes;

    // Pago
    @Column(name = "payment_status")
    private String paymentStatus;

}
