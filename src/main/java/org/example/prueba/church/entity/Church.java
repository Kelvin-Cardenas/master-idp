package org.example.prueba.church.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "church")
public class Church {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "pastor_name")
    private String pastorName;



}
