package com.example.sahamProject.model;

// import groovyjarjarpicocli.CommandLine.Help.Ansi.Text;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_company")
@Getter
@Setter
public class MCompany extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_company")
    private String profileCompany;

    @Column(name = "sector")
    private String sector;
}
