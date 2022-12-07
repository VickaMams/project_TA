package com.kata.trade_accounting.model.enums;

public enum BarcodeType {
    EAN8 ("Европейский на 8 чисел"),
    EAN13 ("Европейский на 13 чисел"),
    Code128 ("Линейный"),
    GTIN ("Международный"),
    UPC ("Американский");


    private final String name;

    BarcodeType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
