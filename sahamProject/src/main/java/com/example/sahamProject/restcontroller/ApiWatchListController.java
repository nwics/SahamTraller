package com.example.sahamProject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.service.WatchListService;

@RestController
@RequestMapping("/api/watchlist")
public class ApiWatchListController {

    @Autowired
    private WatchListService watchListService;

    @GetMapping("")
    public ResponseEntity<?> getAllData() {
        List<MCompany> getAllData = watchListService.getAllData();

        if (getAllData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(getAllData, HttpStatus.OK);
    }
}
