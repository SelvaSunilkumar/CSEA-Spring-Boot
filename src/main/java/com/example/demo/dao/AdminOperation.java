package com.example.demo.dao;

import com.example.demo.modal.AdminDetails;

import java.util.List;
import java.util.UUID;

public interface AdminOperation {

    int addAdmin(UUID uuid, AdminDetails adminDetails);

    default int addAdmin(AdminDetails adminDetails) {
        UUID id = UUID.randomUUID();
        adminDetails.setId(id.toString());
        return addAdmin(id, adminDetails);
    }

    String encryptPassword(String password);

    List<AdminDetails> getAllAdmins();

}
