package com.example.sahamProject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.model.MStockNews;
import com.example.sahamProject.service.StockNewsService;

@RestController
@RequestMapping("/api/")
public class ApiStockNews {

    @Autowired
    private StockNewsService stockNewsService;

    @GetMapping("all")
    public ResponseEntity<?> getAllData() {

        List<MStockNews> response = stockNewsService.getAllNews();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
