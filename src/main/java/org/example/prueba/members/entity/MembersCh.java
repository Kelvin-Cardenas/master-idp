package org.example.prueba.members.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.prueba.church.entity.Church;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "members")
public class MembersCh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "document_number" , unique = true)
    private String documentNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "conversion_date")
    private LocalDate conversionDate;

    @Column(name = "baptism_date")
    private LocalDate baptismDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "church_id")
    private Church church;












}
