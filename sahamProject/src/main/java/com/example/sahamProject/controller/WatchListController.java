package com.example.sahamProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/watchlist")
public class WatchListController {
    @GetMapping("/index")
    public String index() {
        return "watchlist/index";
    }
}
