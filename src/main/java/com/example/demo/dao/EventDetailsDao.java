package com.example.demo.dao;

import com.example.demo.modal.EventDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventDetailsDao extends JpaRepository<EventDetails, Integer> {

    @Query(value = "SELECT COUNT(*) FROM event_details e WHERE e.event_id = ?1 AND e.academic_start = ?2 AND e.academic_end = ?3", nativeQuery = true)
    public int isEventDetailPresent(String eventId, String acadStart, String acadEnd);

    @Query(value = "SELECT * FROM event_details e WHERE e.event_id = ?1", nativeQuery = true)
    List<EventDetails> getAllEventDetailsView(String eventId);

    @Query(value = "SELECT * FROM event_details e WHERE e.event_id = ?1 AND academic_start = ?2 AND academic_end = ?3", nativeQuery = true)
    EventDetails getEventInfo(String eventDetails, String academicStart, String academicEnd);
}
