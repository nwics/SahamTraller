package com.example.sahamProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.CompanyRepository;
import com.example.sahamProject.dao.StockPricesRepository;
import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.TStockPrices;

@Service
public class DashboardService {

    @Autowired
    private StockPricesRepository stockPricesRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<TStockPrices> getAllStockPrices() {
        return stockPricesRepository.findAll();
    }

    public List<MCompany> getAllCompany() {
        return companyRepository.findAll();
    }
}
