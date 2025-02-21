package com.example.sahamProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sahamProject.model.TCustomerHistory;

public interface CustomerHistoryRepository extends JpaRepository<TCustomerHistory, Long> {

}
