package org.example.prueba.members.controller;

import jakarta.validation.Valid;
import org.example.prueba.church.dto.ChurchRequestDto;
import org.example.prueba.church.dto.ChurchResponseDto;
import org.example.prueba.members.dto.MembersRequest;
import org.example.prueba.members.dto.MembersResponseDto;
import org.example.prueba.members.service.MembersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/members")
public class MembersController {

    private final MembersService membersService;

    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }



    @PostMapping
    public ResponseEntity<MembersResponseDto> createMember(@Valid @RequestBody MembersRequest membersRequest){
        return ResponseEntity.ok(membersService.createMember(membersRequest));

    }
    @GetMapping
    public ResponseEntity<List<MembersResponseDto>> listAll(){
        return  ResponseEntity.ok(membersService.listAllMember());

    }



}
