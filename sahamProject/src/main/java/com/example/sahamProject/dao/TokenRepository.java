package com.example.sahamProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sahamProject.model.TToken;

@Repository
public interface TokenRepository extends JpaRepository<TToken, Long> {

    List<TToken> findByEmailAndIsExpiredFalse(String email);

    List<TToken> findByEmailAndIsDeleteFalse(String email);
}
