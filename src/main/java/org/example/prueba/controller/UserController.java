package org.example.prueba.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.prueba.dto.UserRequestDTO;
import org.example.prueba.dto.UserResponseDTO;
import org.example.prueba.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(
            @Valid @RequestBody UserRequestDTO dto) {

        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public List<UserResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO dto) {

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
