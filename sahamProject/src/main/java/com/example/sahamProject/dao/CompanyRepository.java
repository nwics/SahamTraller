package com.example.sahamProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sahamProject.model.MCompany;

public interface CompanyRepository extends JpaRepository<MCompany, Long> {

}
