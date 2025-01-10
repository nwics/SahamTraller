package com.example.sahamProject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MCustomer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "biodata_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MBiodata mBiodata;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "dob")
    private LocalDateTime dob;

    @Column(name = "gender")
    private String gender;

}
