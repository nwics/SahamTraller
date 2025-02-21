package com.example.sahamProject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.TCustomerHistory;
import com.example.sahamProject.model.TStockPrices;
import com.example.sahamProject.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class ApiTransactionController {

    @Autowired
    private TransactionService transactionService;

    // @Autowired
    // private

    @GetMapping("")
    public ResponseEntity<?> getAllCompanies() {
        // List<MCompany> response = transactionService.getAllCompany();
        List<TStockPrices> prices = transactionService.getAllPrices();
        if (prices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomerHistory(TCustomerHistory history) {
        String response = transactionService.addData(history);

        return ResponseEntity.ok(response);
    }
}
