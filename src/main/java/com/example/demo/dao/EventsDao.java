package com.example.demo.dao;

import com.example.demo.modal.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventsDao extends JpaRepository<Events, Integer> {

    @Query(value = "SELECT COUNT(e.name) FROM events e WHERE e.name = ?1", nativeQuery = true)
    int isEventAvailable(String eventName);

}
