package com.example.sahamProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.CompanyRepository;
import com.example.sahamProject.dao.SheetCategoryRepository;
import com.example.sahamProject.dao.StockPricesRepository;
import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.MSheetCategory;
import com.example.sahamProject.model.TStockPrices;

@Service
public class StockDetailService {

    @Autowired
    private SheetCategoryRepository sheetCategoryRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockPricesRepository stockPricesRepository;

    public List<MSheetCategory> getAllSheetCategory() {
        return sheetCategoryRepository.findAll();
    }

    public List<TStockPrices> getAllStockPrices() {
        return stockPricesRepository.findAll();
    }

    public MCompany getById(Long id) {
        MCompany temp = this.companyRepository.findByIdAndIsDeleteFalse(id).get(0);
        return temp;
    }

}
