package com.kata.trade_accounting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
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
