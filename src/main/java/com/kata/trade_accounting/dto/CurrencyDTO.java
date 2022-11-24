package com.kata.trade_accounting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class CurrencyDTO {

    private Long id;
    private boolean accountingCurrency;
    private String shortTitle;
    private String fullTitle;
    private Integer numericCode;
    private String letterCode;
    private Double exchangeRate;
}
