package com.kata.trade_accounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityRresponseDto {

    private Long id;

    private String shortName;

    private String code;

    private boolean removed;

}
