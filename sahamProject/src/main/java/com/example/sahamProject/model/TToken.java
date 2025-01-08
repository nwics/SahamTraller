package com.example.sahamProject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_token")
@Setter
@Getter
public class TToken extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MUser mUserId;

    @Column(name = "token")
    private String token;

    @Column(name = "expired_on")
    private LocalDateTime expiredOn;

    @Column(name = "is_expired")
    private Boolean isExpired;

    @Column(name = "used_for")
    private String usedFor;
}
