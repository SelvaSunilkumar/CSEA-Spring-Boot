package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("csea")
public class Home {

    @GetMapping("/admin")
    public String hello(Model model) {
        model.addAttribute("title", "CSEA Admin - Dashboard");
        model.addAttribute("access", 0);
        return "admin";
    }

    @GetMapping("/manage-admin")
    public String manageAdmin(Model model) {
        model.addAttribute("title", "CSEA - Manage Admin");
        model.addAttribute("access", 1);
        return "admin";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("title", "CSEA - Manage Registration");
        model.addAttribute("access", 2);
        return "adminRegistration";
    }

    @GetMapping("/registration/{eventName}")
    public String registrationEvent(Model model, @PathVariable("eventName") String eventName) {
        String title = eventName.replace('-', ' ');
        model.addAttribute("access",0);
        model.addAttribute("title", "Registration - " + title);
        model.addAttribute("eventName", eventName);
        model.addAttribute("eventTitle", title);
        return "eventRegistration";
    }

}
