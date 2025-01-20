package com.example.sahamProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sahamProject.model.MCompany;

public interface CompanyRepository extends JpaRepository<MCompany, Long> {

    List<MCompany> findByIdAndIsDeleteFalse(Long id);
}
