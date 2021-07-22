package com.example.demo.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventDetails {
    @Id
    private String id;
    private String eventId;
    private String eventName;
    private String description;
    private String registrationStart;
    private String registrationEnd;
    private String academicStart;
    private String academicEnd;
    private int teamSize;

    public EventDetails() {

    }

    public EventDetails(@JsonProperty("id") String id, @JsonProperty("eventId") String eventId, @JsonProperty("eventName") String eventName, @JsonProperty("description") String description, @JsonProperty("registrationStart") String registrationStart, @JsonProperty("registrationEnd") String registrationEnd, @JsonProperty("academicStart") String academicStart, @JsonProperty("academicEnd") String academicEnd, @JsonProperty("teamSize") int teamSize) {
        this.id = id;
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.registrationStart = registrationStart;
        this.registrationEnd = registrationEnd;
        this.academicStart = academicStart;
        this.academicEnd = academicEnd;
        this.teamSize = teamSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
