package com.example.sahamProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sahamProject.dao.StockNewsRepository;
// import com.example.sahamProject.model.MMarketTrends;
import com.example.sahamProject.model.MStockNews;

@Service
public class StockNewsService {
    @Autowired
    private StockNewsRepository stockNewsRepository;

    public List<MStockNews> getAllNews() {
        return stockNewsRepository.findAll();

    }
}
