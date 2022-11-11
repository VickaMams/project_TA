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

    private String counterpartyType;
    private String INN;
    private String fullName;
    private String lawAddress;
    private String addressComments;
    private String KPP;
    private String OGRN;
    private String OKPO;
}
