package org.example.prueba.mapper;

import org.example.prueba.menber.dto.EventRegistrationRequest;
import org.example.prueba.menber.dto.EventRegistrationResponse;
import org.example.prueba.menber.entity.EventRegistration;

public class EventRegistrationMapper{

public static EventRegistration toEntity(EventRegistrationRequest req) {
    EventRegistration e = new EventRegistration();
    e.setEventName(req.getEventName());
    e.setEventDate(req.getEventDate());
    e.setEventLocation(req.getEventLocation());
    e.setEventCost(req.getEventCost());

    e.setFullName(req.getFullName());
    e.setDocumentNumber(req.getDocumentNumber());
    e.setPhone(req.getPhone());
    e.setEmail(req.getEmail());

    e.setMemberRole(req.getMemberRole());
    e.setChurchCampus(req.getChurchCampus());

    e.setRegistrationCode(req.getRegistrationCode());
    e.setNotes(req.getNotes());

    e.setPaymentStatus(req.getPaymentStatus());


    return e;
}

public static EventRegistrationResponse toResponse(EventRegistration e) {
    EventRegistrationResponse r = new EventRegistrationResponse();
    r.setId(e.getId());

    r.setEventName(e.getEventName());
    r.setEventDate(e.getEventDate());
    r.setEventLocation(e.getEventLocation());
    r.setEventCost(e.getEventCost());

    r.setFullName(e.getFullName());
    r.setDocumentNumber(e.getDocumentNumber());
    r.setPhone(e.getPhone());
    r.setEmail(e.getEmail());

    r.setMemberRole(e.getMemberRole());
    r.setChurchCampus(e.getChurchCampus());

    r.setRegistrationCode(e.getRegistrationCode());
    r.setNotes(e.getNotes());

    r.setPaymentStatus(e.getPaymentStatus());


    return r;
}

public static void updateEntity(EventRegistration e, EventRegistrationRequest req) {
    // Solo campos actualizables
    e.setEventName(req.getEventName());
    e.setEventDate(req.getEventDate());
    e.setEventLocation(req.getEventLocation());
    e.setEventCost(req.getEventCost());

    e.setFullName(req.getFullName());
    e.setDocumentNumber(req.getDocumentNumber());
    e.setPhone(req.getPhone());
    e.setEmail(req.getEmail());

    e.setMemberRole(req.getMemberRole());
    e.setChurchCampus(req.getChurchCampus());

    e.setRegistrationCode(req.getRegistrationCode());
    e.setNotes(req.getNotes());

    e.setPaymentStatus(req.getPaymentStatus());


}
}

