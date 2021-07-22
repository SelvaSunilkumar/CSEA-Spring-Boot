package com.example.demo.dao;

import com.example.demo.modal.AdminDetails;
import com.example.demo.modal.EventDetails;
import com.example.demo.modal.EventDetailsView;
import com.example.demo.modal.Events;

import java.util.List;
import java.util.UUID;

public interface AdminOperation {

    int addAdmin(UUID uuid, AdminDetails adminDetails);

    default int addAdmin(AdminDetails adminDetails) {
        UUID id = UUID.randomUUID();
        adminDetails.setId(id.toString());
        return addAdmin(id, adminDetails);
    }

    int addEvent(UUID uuid, Events events);

    default int addEvent(Events events) {
        UUID id = UUID.randomUUID();
        events.setId(id.toString());
        return addEvent(id, events);
    }

    int addEventDetails(UUID uuid, EventDetails eventDetails);

    default int addEventDetails(EventDetails eventDetails) {
        UUID id = UUID.randomUUID();
        eventDetails.setId(id.toString());
        return addEventDetails(id, eventDetails);
    }

    String encryptPassword(String password);

    List<AdminDetails> getAllAdmins();

    List<Events> getAllEvents();

    List<EventDetails> getAllEventsDetailsView(String eventId);

}
