package com.example.demo.controller;

//import service

import com.example.demo.modal.AdminDetails;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
