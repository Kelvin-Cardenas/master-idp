package org.example.prueba.eventRegistration.service;


import org.example.prueba.eventRegistration.dto.EventRegistrationRequest;
import org.example.prueba.eventRegistration.dto.EventRegistrationResponse;

import java.util.List;

public interface EventRegistrationService {
    EventRegistrationResponse create(EventRegistrationRequest request);

    EventRegistrationResponse update(Long id, EventRegistrationRequest request);

    EventRegistrationResponse getById(Long id);

    EventRegistrationResponse getByCode(String registrationCode);

    List<EventRegistrationResponse> listAll();

    void delete(Long id);
}
