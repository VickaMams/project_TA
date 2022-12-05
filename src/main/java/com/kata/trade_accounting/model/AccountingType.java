package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

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

    @OneToMany(mappedBy = "accountingType", cascade = CascadeType.ALL)
    private Set<Product> products;

    private boolean removed;
}
