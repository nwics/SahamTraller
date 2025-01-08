package com.example.sahamProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portofolio")
public class PortofolioController {

    @GetMapping("/index")
    public String index() {
        return "portofolio/index";
    }
}
