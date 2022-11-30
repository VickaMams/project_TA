package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class AccountingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AccountingTypeSelection selection;
    private PersonalProtectiveEquipmentName equipmentName;
    private PersonalProtectiveEquipmentType equipmentType;

    private String productTypeCode;
    private Double tareCapacity;
    private Double alcoholStrength;
    private boolean taxMark;
    private String EGAIScodes;

    @OneToOne(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
    private Product product;

    private boolean removed;
}
