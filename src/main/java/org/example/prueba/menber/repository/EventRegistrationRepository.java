package org.example.prueba.menber.repository;


import org.example.prueba.menber.entity.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {

    Optional<EventRegistration> findByRegistrationCode(String registrationCode);

    List<EventRegistration> findByEventNameIgnoreCase(String eventName);

    List<EventRegistration> findByChurchCampusIgnoreCase(String churchCampus);
}
