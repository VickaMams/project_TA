package com.kata.trade_accounting.dto;

import com.kata.trade_accounting.model.Group;
import com.kata.trade_accounting.model.Nds;
import com.kata.trade_accounting.model.UnitsOfMeasurement;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDTO {

    private Long id;
    private String productName;
    private String description;
    private Group group;
    private String country;
    private String supplier;
    private String article;
    private String code;
    private String externalCode;
    private UnitsOfMeasurement unitOfMeasurement;
    private String weight;
    private String volume;
    private Nds nds;
    private AccountingTypeDTO accountingType;

    private boolean thisProduct;
    private boolean thisService;
    private boolean removed;
}
