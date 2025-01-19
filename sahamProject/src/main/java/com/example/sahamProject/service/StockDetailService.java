package com.example.sahamProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.SheetCategoryRepository;
import com.example.sahamProject.model.MSheetCategory;

@Service
public class StockDetailService {

    @Autowired
    private SheetCategoryRepository sheetCategoryRepository;

    public List<MSheetCategory> getAllSheetCategory() {
        return sheetCategoryRepository.findAll();
    }
}
