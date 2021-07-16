package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("csea")
public class Home {

    @GetMapping("/admin")
    public String hello(Model model) {
        model.addAttribute("access", 0);
        return "admin";
    }

    @GetMapping("/manage-admin")
    public String manageAdmin(Model model) {
        model.addAttribute("access", 1);
        return "admin";
    }

}
