package com.example.sahamProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sahamProject.model.MStockNews;

public interface StockNewsRepository extends JpaRepository<MStockNews, Long> {

}
