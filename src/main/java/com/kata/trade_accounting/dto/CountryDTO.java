package com.kata.trade_accounting.dto;

import lombok.Data;

@Data
public class CountryDTO {
    private Long id;

    private String shortName;

    private String fullName;

    private int digitalCode;

    private String doubleLetterCode;

    private String tripleLetterCode;
}
