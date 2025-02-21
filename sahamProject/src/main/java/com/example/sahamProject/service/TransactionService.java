package com.example.sahamProject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sahamProject.dao.CompanyRepository;
import com.example.sahamProject.dao.CustomerHistoryRepository;
import com.example.sahamProject.dao.StockPricesRepository;
import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.TCustomerHistory;
import com.example.sahamProject.model.TStockPrices;

@Service
public class TransactionService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockPricesRepository stockPricesRepository;

    @Autowired
    private CustomerHistoryRepository customerHistoryRepository;

    public List<MCompany> getAllCompany() {
        return companyRepository.findAll();
    }

    public List<TStockPrices> getAllPrices() {
        return stockPricesRepository.findDistinctStockPrices();
    }

    public String addData(TCustomerHistory history) {

        if (history.getId() == null) {
            TCustomerHistory tempCustomerHistory = new TCustomerHistory();
            tempCustomerHistory.setCreatedOn(LocalDateTime.now());
            tempCustomerHistory.setTransactionDate(history.getTransactionDate());
            tempCustomerHistory.setUserId(history.getUserId());
            tempCustomerHistory.setMCompanyId(history.getMCompanyId());
            tempCustomerHistory.setTransactionType(history.getTransactionType());
            tempCustomerHistory.setAmountLot(history.getAmountLot());
            tempCustomerHistory.setAmount(history.getAmount());
            tempCustomerHistory.setPrice(history.getPrice());

            customerHistoryRepository.save(tempCustomerHistory);
            return "Data history berhasil ditambahkan";
        } else {
            return "Data sudah ada";
        }

    }

}
