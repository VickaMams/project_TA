package com.kata.trade_accounting.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDTO {

    private Long id;
    private String productName;
    private String description;
    private String group;
    private String country;
    private String supplier;
    private String article;
    private String code;
    private String externalCode;
    private String unitOfMeasurement;
    private String weight;
    private String volume;
    private String NDS;

    private boolean thisProduct;
    private boolean thisService;
    private boolean removed;
}
