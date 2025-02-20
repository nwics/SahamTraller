package com.example.sahamProject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sahamProject.model.TStockPrices;

public interface StockPricesRepository extends JpaRepository<TStockPrices, Long> {
    List<TStockPrices> findByIdAndIsDeleteFalse(Long id);

    @Query(value = "select distinct on (company_id) * from stock_prices where is_delete = false", nativeQuery = true)
    List<TStockPrices> findDistinctStockPrices();

}
