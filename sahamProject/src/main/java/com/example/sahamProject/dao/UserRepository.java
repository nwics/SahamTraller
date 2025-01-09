package com.example.sahamProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sahamProject.model.MUser;

@Repository
public interface UserRepository extends JpaRepository<MUser, Long> {

    List<MUser> findByIsDelete(Boolean isDelete);

    List<MUser> findByEmailAndIsDeleteFalse(String email);

    // List<MUser> findById(Long id);
}
