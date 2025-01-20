package com.example.sahamProject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sahamProject.model.TStockPrices;

public interface StockPricesRepository extends JpaRepository<TStockPrices, Long> {
    List<TStockPrices> findByIdAndIsDeleteFalse(Long id);
}
