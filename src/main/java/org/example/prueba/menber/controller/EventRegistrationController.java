package org.example.prueba.menber.controller;





import org.example.prueba.menber.dto.EventRegistrationRequest;
import org.example.prueba.menber.dto.EventRegistrationResponse;
import org.example.prueba.menber.service.EventRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-registrations")
public class EventRegistrationController {

    private final EventRegistrationService service;

    public EventRegistrationController(EventRegistrationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventRegistrationResponse> create(@RequestBody EventRegistrationRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventRegistrationResponse> update(@PathVariable Long id,
                                                            @RequestBody EventRegistrationRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventRegistrationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/code/{registrationCode}")
    public ResponseEntity<EventRegistrationResponse> getByCode(@PathVariable String registrationCode) {
        return ResponseEntity.ok(service.getByCode(registrationCode));
    }

    @GetMapping
    public ResponseEntity<List<EventRegistrationResponse>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
