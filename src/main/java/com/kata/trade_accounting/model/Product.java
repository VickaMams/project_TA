package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    private String group;
    private String country;
    private String supplier;
    private String article;
    private String code;
    private String externalCode;
    private String unitOfMeasurement;
    private String weight;
    private String volume;
    private String NDS;

    private boolean thisProduct;
    private boolean thisService;
    private boolean removed;
}
