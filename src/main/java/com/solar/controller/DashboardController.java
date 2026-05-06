package com.solar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "index"; // This looks for src/main/resources/templates/index.html
    }
}