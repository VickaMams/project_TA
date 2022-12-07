package com.kata.trade_accounting.dto;


import com.kata.trade_accounting.model.enums.BarcodeType;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class BarcodeDTO {

    private Long id;
    Enum<BarcodeType> barcodeEnum;
    private Long number;
}
