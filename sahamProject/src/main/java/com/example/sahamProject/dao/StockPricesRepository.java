package com.example.sahamProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sahamProject.model.TStockPrices;

public interface StockPricesRepository extends JpaRepository<TStockPrices, Long> {

}
