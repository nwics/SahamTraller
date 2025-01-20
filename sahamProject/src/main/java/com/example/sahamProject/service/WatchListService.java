package com.example.sahamProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.CompanyRepository;
import com.example.sahamProject.model.MCompany;

@Service
public class WatchListService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<MCompany> getAllData() {
        return companyRepository.findAll();
    }
}
