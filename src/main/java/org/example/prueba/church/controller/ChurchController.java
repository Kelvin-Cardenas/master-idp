package org.example.prueba.church.controller;

import jakarta.validation.Valid;
import org.example.prueba.church.dto.ChurchRequestDto;
import org.example.prueba.church.dto.ChurchResponseDto;
import org.example.prueba.church.service.ChurchService;
import org.example.prueba.members.dto.MembersRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/church")
public class ChurchController {

   /* private final ChurchService  service;

    public ChurchController(ChurchService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ChurchResponseDto>> listChurch() {


        return ResponseEntity.ok(service.lisAllchurch());




    }*/

}
