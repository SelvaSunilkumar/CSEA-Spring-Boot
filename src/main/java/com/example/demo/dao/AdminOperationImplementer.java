package com.example.demo.dao;

import com.example.demo.modal.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("adminAuth")
public class AdminOperationImplementer implements AdminOperation {

    @Autowired
    AdminDao repo;

    @Override
    public int addAdmin(UUID uuid, AdminDetails adminDetails) {
        if (uuid == null) {
            adminDetails.setId(UUID.randomUUID().toString());;
        }
        repo.save(adminDetails);
        //status 200 - Successful
        return 200;
    }
}
