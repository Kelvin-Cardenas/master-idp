package org.example.prueba.members.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.prueba.church.dto.ChurchResponseDto;

import java.time.LocalDate;
@Getter
@Setter
public class MembersResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private String gender;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate conversionDate;
    private LocalDate baptismDate;
    private ChurchResponseDto church;





}
