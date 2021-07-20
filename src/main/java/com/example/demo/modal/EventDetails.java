package com.example.demo.modal;

public class EventDetails {
    private String eventId;
    private String eventName;
    private String registrationStart;
    private String registrationEnd;
    private String academicStart;
    private String academicEnd;
    private int teamSize;

    public EventDetails() {

    }

    public EventDetails(String eventId, String eventName, String registrationStart, String registrationEnd, String academicStart, String academicEnd, int teamSize) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.registrationStart = registrationStart;
        this.registrationEnd = registrationEnd;
        this.academicStart = academicStart;
        this.academicEnd = academicEnd;
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

    public String getRegistrationStart() {
        return registrationStart;
    }

    public void setRegistrationStart(String registrationStart) {
        this.registrationStart = registrationStart;
    }

    public String getRegistrationEnd() {
        return registrationEnd;
    }

    public void setRegistrationEnd(String registrationEnd) {
        this.registrationEnd = registrationEnd;
    }

    public String getAcademicStart() {
        return academicStart;
    }

    public void setAcademicStart(String academicStart) {
        this.academicStart = academicStart;
    }

    public String getAcademicEnd() {
        return academicEnd;
    }

    public void setAcademicEnd(String academicEnd) {
        this.academicEnd = academicEnd;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
