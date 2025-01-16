package com.example.sahamProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sahamProject.model.MUser;

@Repository
public interface UserRepository extends JpaRepository<MUser, Long> {

    List<MUser> findByIsDelete(Boolean isDelete);

    List<MUser> findByEmailAndIsDeleteFalse(String email);

    Boolean existsByEmail(String email);

    Boolean existsByPassword(String password);

    // @Query(value = """
    // select email, password where is_delete = false
    // """, nativeQuery = true)
    // List<MUser> findByEmailPasswordAndIsDeleteFalse(String email, String
    // password);
    // List<MUser> findById(Long id);
}
