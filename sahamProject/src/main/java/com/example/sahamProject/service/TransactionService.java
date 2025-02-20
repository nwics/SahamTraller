package com.example.sahamProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.CompanyRepository;
import com.example.sahamProject.dao.StockPricesRepository;
import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.TStockPrices;

@Service
public class TransactionService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockPricesRepository stockPricesRepository;

    public List<MCompany> getAllCompany() {
        return companyRepository.findAll();
    }

    public List<TStockPrices> getAllPrices() {
        return stockPricesRepository.findDistinctStockPrices();
    }
}
