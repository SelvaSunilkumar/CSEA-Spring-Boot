package com.example.demo.dao;

import com.example.demo.modal.AdminDetails;
import com.example.demo.modal.EventDetails;
import com.example.demo.modal.EventDetailsView;
import com.example.demo.modal.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@Repository("adminAuth")
public class AdminOperationImplementer implements AdminOperation {

    @Autowired
    AdminDao repo;

    @Autowired
    EventsDao erepo;

    @Autowired
    EventDetailsDao eventDetailsRepo;

    @Override
    public int addAdmin(UUID uuid, AdminDetails adminDetails) {
        if (uuid == null) {
            adminDetails.setId(UUID.randomUUID().toString());;
        }

        if (repo.isUserPresent(adminDetails.getUsername()) > 0) {
            return 404;
        }

        String hashedPassword = encryptPassword(adminDetails.getPassword());
        if (hashedPassword == null) {
            return 107;
        }
        adminDetails.setPassword(hashedPassword);
        repo.save(adminDetails);
        if (repo.isUserPresent(adminDetails.getUsername()) > 0) {
            //status 200 - Successful
            return 200;
        }
        //status 107 - Failed
        return 107;
    }

    @Override
    public int addEvent(UUID uuid, Events events) {
        if (uuid == null) {
            events.setId(UUID.randomUUID().toString());
        }
        if (erepo.isEventAvailable(events.getName()) > 0) {
            return 404;
        }
        erepo.save(events);
        if (erepo.isEventAvailable(events.getName()) > 0) {
            return 200;
        }
        return 107;
    }

    @Override
    public int addEventDetails(UUID uuid, EventDetails eventDetails) {
        if (eventDetailsRepo.isEventDetailPresent(eventDetails.getEventId(), eventDetails.getAcademicStart(), eventDetails.getAcademicEnd()) > 0) {
            return 404;
        }
        eventDetailsRepo.save(eventDetails);
        if (eventDetailsRepo.isEventDetailPresent(eventDetails.getEventId(), eventDetails.getAcademicStart(), eventDetails.getAcademicEnd()) > 0) {
            return 200;
        }
        return 107;
    }

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] passwordHash = messageDigest.digest(password.getBytes());
            BigInteger integer = new BigInteger(1, passwordHash);
            String hashPassword = integer.toString(16);
            while (hashPassword.length() < 32) {
                hashPassword = "0" + hashPassword;
            }
            return hashPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EventDetails getEventInfo(String eventId, String academicStart, String academicEnd) {
        EventDetails eventDetails = eventDetailsRepo.getEventInfo(eventId, academicStart, academicEnd);
        if (eventDetails == null) {
            return null;
        }
        return eventDetails;
    }

    @Override
    public List<AdminDetails> getAllAdmins() {
        return  repo.findAll();
    }

    @Override
    public List<Events> getAllEvents() {
        return erepo.findAll();
    }

    @Override
    public List<EventDetails> getAllEventsDetailsView(String eventId) {
        return eventDetailsRepo.getAllEventDetailsView(eventId);
    }
}
