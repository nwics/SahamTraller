package com.example.sahamProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sahamProject.model.MMarketTrends;

public interface StockNewsRepository extends JpaRepository<MMarketTrends, Long> {

}
