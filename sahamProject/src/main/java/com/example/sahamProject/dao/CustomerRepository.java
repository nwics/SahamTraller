package com.example.sahamProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sahamProject.model.MCustomer;

@Repository
public interface CustomerRepository extends JpaRepository<MCustomer, Long> {

}
