package org.example.prueba.menber.service;


import org.example.prueba.menber.dto.EventRegistrationRequest;
import org.example.prueba.menber.dto.EventRegistrationResponse;

import java.util.List;

public interface EventRegistrationService {
    EventRegistrationResponse create(EventRegistrationRequest request);

    EventRegistrationResponse update(Long id, EventRegistrationRequest request);

    EventRegistrationResponse getById(Long id);

    EventRegistrationResponse getByCode(String registrationCode);

    List<EventRegistrationResponse> listAll();

    void delete(Long id);
}
