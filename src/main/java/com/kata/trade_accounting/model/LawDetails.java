package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class LawDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CounterpartyType;
    private String INN;
    private String FullName;
    private String LawAddress;
    private String AddressComments;
    private String KPP;
    private String OGRN;
    private String OKPO;
}
