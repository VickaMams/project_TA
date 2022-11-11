package com.kata.trade_accounting.dto;

import lombok.Data;

@Data
public class LawDetailsDTO {
    private String CounterpartyType;
    private String INN;
    private String FullName;
    private String LawAddress;
    private String AddressComments;
    private String KPP;
    private String OGRN;
    private String OKPO;
}
