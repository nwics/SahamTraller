package com.example.sahamProject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.model.MSheetCategory;
import com.example.sahamProject.service.StockDetailService;

@RestController
@RequestMapping("/api/stockdetail")
public class ApiStockDetailController {

    @Autowired
    private StockDetailService stockDetailService;

    @GetMapping("")
    public ResponseEntity<?> getAllData() {
        List<MSheetCategory> listData = stockDetailService.getAllSheetCategory();
        if (listData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listData, HttpStatus.OK);
    }
}
