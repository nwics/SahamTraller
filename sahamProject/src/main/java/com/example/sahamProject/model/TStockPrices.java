package com.example.sahamProject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stock_prices")
@Setter
@Getter
public class TStockPrices extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MCompany mCompany;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "open_price", nullable = false)
    private String openPrice;

    @Column(name = "close_price", nullable = false)
    private String closePrice;

    @Column(name = "high_price", nullable = false)
    private String highPrice;

    @Column(name = "low_price", nullable = false)
    private String lowPrice;

    @Column(name = "volume")
    private Integer volume;
}
