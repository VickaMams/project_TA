package com.kata.trade_accounting.model;


import com.kata.trade_accounting.model.enums.BarcodeType;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Barcode {
    Enum<BarcodeType> barcodeEnum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    private boolean removed;
}
