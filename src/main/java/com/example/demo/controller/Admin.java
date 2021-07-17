package com.example.demo.controller;

import com.example.demo.modal.AdminCustomDetails;
import com.example.demo.modal.AdminDetails;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/admin")
@RestController
public class Admin {

    private final AdminService adminService;

    @Autowired
    public Admin(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("add")
    public int addAdmin(@RequestBody AdminDetails adminDetails) {
        if (adminService.isValidString(adminDetails.getUsername()) || adminService.isValidString(adminDetails.getPassword()))  {
            //Error 301 : Special Character found in the string
            return 301;
        }
        return adminService.addAdmin(adminDetails);
    }

    @GetMapping("all")
    public List<AdminCustomDetails> getAllAdmins() {
        List<AdminDetails> adminDetails = adminService.getAllAdmins();
        List<AdminCustomDetails> customDetails = new ArrayList<>();
        for (int index = 0; index < adminDetails.size(); index++) {
            customDetails.add(new AdminCustomDetails(adminDetails.get(index).getUsername()));
        }
        return customDetails;
    }

}
