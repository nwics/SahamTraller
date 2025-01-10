package com.example.sahamProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sahamProject.model.MAdmin;

@Repository
public interface AdminRepository extends JpaRepository<MAdmin, Long> {

}
