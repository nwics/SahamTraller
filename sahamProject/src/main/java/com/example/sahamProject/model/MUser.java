package com.example.sahamProject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_user")
@Getter
@Setter

public class MUser extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MRole mRole;

    @OneToOne
    @JoinColumn(name = "biodata_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MBiodata mBiodataId;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

}
