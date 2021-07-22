package com.example.demo.modal;

public class EventDetailsView {
    private String eventId;
    private String eventName;
    private String academicYear;
    private String description;
    private String registrationOpen;
    private String registrationClose;
    private int teamSize;

    public EventDetailsView(String eventId, String eventName, String academicYear, String description, String registrationOpen, String registrationClose, int teamSize) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.academicYear = academicYear;
        this.description = description;
        this.registrationOpen = registrationOpen;
        this.registrationClose = registrationClose;
        this.teamSize = teamSize;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegistrationOpen() {
        return registrationOpen;
    }

    public void setRegistrationOpen(String registrationOpen) {
        this.registrationOpen = registrationOpen;
    }

    public String getRegistrationClose() {
        return registrationClose;
    }

    public void setRegistrationClose(String registrationClose) {
        this.registrationClose = registrationClose;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
