package com.example.demo.service;

import com.example.demo.dao.AdminOperation;
import com.example.demo.modal.AdminDetails;
import com.example.demo.modal.EventDetails;
import com.example.demo.modal.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdminService {

    private final AdminOperation adminOperation;

    @Autowired
    public AdminService(@Qualifier("adminAuth") AdminOperation adminOperation) {
        this.adminOperation = adminOperation;
    }

    public boolean isValidString(String input) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(input);
        boolean doContainSpecialCharacter = matcher.find();
        return doContainSpecialCharacter;
    }

    public boolean isValidEventString(String input) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 -]");
        Matcher matcher = pattern.matcher(input);
        boolean doContainSpecialCharacter = matcher.find();
        return doContainSpecialCharacter;
    }

    public int addAdmin(AdminDetails adminDetails) {
        return  adminOperation.addAdmin(adminDetails);
    }

    public int addEvent(Events events) {
        return adminOperation.addEvent(events);
    }

    public int addEventDetails(EventDetails eventDetails) {
        return adminOperation.addEventDetails(eventDetails);
    }

    public EventDetails getEventInfo(String eventId, String academicYear) {
        eventId = eventId.replace("-", " ");
        String[] academicYears = academicYear.split("-");
        String academicStart = academicYears[0];
        String academicEnd = academicYears[1];
        return adminOperation.getEventInfo(eventId, academicStart, academicEnd);
    }

    public List<AdminDetails> getAllAdmins() {
        return adminOperation.getAllAdmins();
    }

    public List<Events> getAllEvents() {
        return adminOperation.getAllEvents();
    }

    public List<EventDetails> getAllEventDetailsView(String eventId) {
        return adminOperation.getAllEventsDetailsView(eventId);
    }
}
