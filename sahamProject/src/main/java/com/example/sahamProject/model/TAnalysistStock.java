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
@Table(name = "t_analysis_stock")
@Setter
@Getter
public class TAnalysistStock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MCompany mCompanyId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MUser mUserId;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "analysis")
    private Integer analysis;

}
