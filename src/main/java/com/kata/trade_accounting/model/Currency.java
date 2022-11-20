package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean accountingCurrency;
    private String shortTitle;
    private String fullTitle;
    private Integer numericCode;
    private String letterCode;
    private Double exchangeRate;
    private boolean removed;
}
