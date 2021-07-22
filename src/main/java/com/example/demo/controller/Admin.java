package com.example.demo.controller;

import com.example.demo.modal.*;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/admin")
@RestController
public class Admin {

    private final AdminService adminService;

    @Autowired
    public Admin(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("add")
    public int addAdmin(@RequestBody AdminDetails adminDetails) {
        if (adminService.isValidString(adminDetails.getUsername()) || adminService.isValidString(adminDetails.getPassword()))  {
            //Error 301 : Special Character found in the string
            return 301;
        }
        return adminService.addAdmin(adminDetails);
    }

    @GetMapping("all")
    public List<AdminCustomDetails> getAllAdmins() {
        List<AdminDetails> adminDetails = adminService.getAllAdmins();
        List<AdminCustomDetails> customDetails = new ArrayList<>();
        for (int index = 0; index < adminDetails.size(); index++) {
            customDetails.add(new AdminCustomDetails(adminDetails.get(index).getUsername()));
        }
        return customDetails;
    }

    @PostMapping("addEvent")
    public int addEvent(@RequestBody Events events) {
        if (adminService.isValidEventString(events.getName())) {
            return 301;
        }
        return adminService.addEvent(events);
    }

    @GetMapping("allEvents")
    public List<EventsURLDetails> getAllEvents() {
        List<EventsURLDetails> urlDetails = new ArrayList<>();
        List<Events> events = adminService.getAllEvents();

        for (int i=0; i<events.size(); i++) {
            Events eventDetails = events.get(i);
            String url = eventDetails.getName();
            url = url.replace(' ','-');
            urlDetails.add(new EventsURLDetails(eventDetails.getId(), eventDetails.getName(), url));
        }
        return urlDetails;
    }

    @PostMapping("event/registration")
    public int manageEvent(@RequestBody EventDetails eventDetails) {
        if (adminService.isValidEventString(eventDetails.getEventName())) {
            return 301;
        }
        eventDetails.setEventId(eventDetails.getEventId().replace("-"," "));
        return adminService.addEventDetails(eventDetails);
    }

    @GetMapping("registration/{id}")
    public String getCustom(@PathVariable("id") String eventId) {
        return eventId.replace('-', ' ');
    }

    @GetMapping("events/{id}")
    public List<EventDetailsView> getEventDetailsView(@PathVariable("id") String eventId) {
        eventId = eventId.replace("-", " ");
        List<EventDetails> eventDetails = adminService.getAllEventDetailsView(eventId);
        List<EventDetailsView> eventDetailsViews = new ArrayList<>();
        for (int iterator = 0; iterator < eventDetails.size(); iterator++) {
            EventDetails details = eventDetails.get(iterator);
            String academicYear = details.getAcademicStart() + "-" + details.getAcademicEnd();
            eventDetailsViews.add(new EventDetailsView(details.getEventId(), details.getEventName(), academicYear, details.getDescription(), details.getRegistrationStart(), details.getRegistrationEnd(), details.getTeamSize()));
        }
        return eventDetailsViews;
    }

}
