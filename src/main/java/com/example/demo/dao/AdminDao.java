package com.example.demo.dao;

import com.example.demo.modal.AdminDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminDao extends JpaRepository<AdminDetails, Integer> {

    @Query(value = "SELECT COUNT(a.username) FROM admin_details a WHERE a.username = ?1", nativeQuery = true)
    public int isUserPresent(String username);

}
