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
@Table(name = "m_sheet_category")
@Setter
@Getter
public class MSheetCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sheet_id", referencedColumnName = "id", nullable = false, insertable = false)
    private MSheet mSheetId;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private LocalDateTime year;

    @Column(name = "quarter")
    private String quarter;

    @Column(name = "price")
    private String price;

}
