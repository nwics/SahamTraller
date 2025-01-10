package com.example.sahamProject.model;

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
@Table(name = "m_admin")
@Setter
@Getter

public class MAdmin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "biodata_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MBiodata mBiodata;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "code")
    private String code;
}
