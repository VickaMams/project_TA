package com.kata.trade_accounting.dto;

import lombok.Data;

@Data
public class LawDetailsDTO {

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
