package com.example.demo.modal;

public class EventInfo {
    private String eventName;
    private String description;
    private String registrationClose;
    private int teamSize;

    public EventInfo() {

    }

    public EventInfo(String eventName, String description, String registrationClose, int teamSize) {
        this.eventName = eventName;
        this.description = description;
        this.registrationClose = registrationClose;
        this.teamSize = teamSize;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
