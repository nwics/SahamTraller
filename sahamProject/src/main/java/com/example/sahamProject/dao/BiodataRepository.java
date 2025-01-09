package com.example.sahamProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sahamProject.model.MBiodata;

@Repository
public interface BiodataRepository extends JpaRepository<MBiodata, Long> {

    List<MBiodata> findByIdAndIsDeleteFalse(Long id);

}
