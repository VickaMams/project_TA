package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    private String country;
    private String supplier;
    private String article;
    private String code;
    private String externalCode;

    @ManyToOne
    @JoinColumn(name = "unit_of_measurement_id")
    private UnitsOfMeasurement unitOfMeasurement;
    private String weight;
    private String volume;

    @ManyToOne
    @JoinColumn(name = "nds_id")
    private Nds NDS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accounting_type_id")
    private AccountingType accountingType;

    private boolean thisProduct;
    private boolean thisService;
    private boolean removed;
}
