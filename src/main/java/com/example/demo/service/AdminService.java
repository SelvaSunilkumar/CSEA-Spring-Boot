package com.example.demo.service;

import com.example.demo.dao.AdminOperation;
import com.example.demo.modal.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminOperation adminOperation;

    @Autowired
    public AdminService(@Qualifier("adminAuth") AdminOperation adminOperation) {
        this.adminOperation = adminOperation;
    }

    public int addAdmin(AdminDetails adminDetails) {
        return  adminOperation.addAdmin(adminDetails);
    }
}
