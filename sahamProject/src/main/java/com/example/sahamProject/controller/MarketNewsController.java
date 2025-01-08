package com.example.sahamProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marketnews")
public class MarketNewsController {

    @GetMapping("/index")
    public String index() {
        return "marketnews/index";
    }
}
