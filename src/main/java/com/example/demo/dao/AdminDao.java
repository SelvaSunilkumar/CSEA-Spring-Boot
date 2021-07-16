package com.example.demo.dao;

import com.example.demo.modal.AdminDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<AdminDetails, Integer> {
}
