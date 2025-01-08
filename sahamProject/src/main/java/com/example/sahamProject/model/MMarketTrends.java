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
@Table(name = "m_market_trends")
@Setter
@Getter
public class MMarketTrends extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false, insertable = false)
    private MCompany mCompanyId;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "trend_name")
    private String trendName;

    @Column(name = "description", length = 255)
    private String description;
}
