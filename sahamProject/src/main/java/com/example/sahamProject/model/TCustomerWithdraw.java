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
@Table(name = "t_customer_withdraw")
@Setter
@Getter
public class TCustomerWithdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MUser mUserId;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MBank mBankId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "otp")
    private Integer otp;
}
