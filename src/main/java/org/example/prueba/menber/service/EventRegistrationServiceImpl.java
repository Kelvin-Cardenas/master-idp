package org.example.prueba.menber.service;



import org.example.prueba.mapper.EventRegistrationMapper;
import org.example.prueba.menber.dto.EventRegistrationRequest;
import org.example.prueba.menber.dto.EventRegistrationResponse;
import org.example.prueba.menber.entity.EventRegistration;
import org.example.prueba.menber.repository.EventRegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventRegistrationServiceImpl implements EventRegistrationService {

    private final EventRegistrationRepository repository;

    public EventRegistrationServiceImpl(EventRegistrationRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public EventRegistrationResponse create(EventRegistrationRequest request) {
        EventRegistration entity = EventRegistrationMapper.toEntity(request);
        entity = repository.save(entity);
        return EventRegistrationMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public EventRegistrationResponse update(Long id, EventRegistrationRequest request) {
        EventRegistration entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado: " + id));
        EventRegistrationMapper.updateEntity(entity, request);
        entity = repository.save(entity);
        return EventRegistrationMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public EventRegistrationResponse getById(Long id) {
        EventRegistration entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado: " + id));
        return EventRegistrationMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public EventRegistrationResponse getByCode(String registrationCode) {
        EventRegistration entity = repository.findByRegistrationCode(registrationCode)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado por código: " + registrationCode));
        return EventRegistrationMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventRegistrationResponse> listAll() {
        return repository.findAll().stream()
                .map(EventRegistrationMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
