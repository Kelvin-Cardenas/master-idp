package org.example.prueba.church.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChurchResponseDto {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String pastorName;
}
