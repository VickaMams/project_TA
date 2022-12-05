package com.kata.trade_accounting.model.enums;

public enum TypeOfProduction {
    INRUSSIA("Произведен в России"),
    ABROAD("Ввезен в РФ");

    private final String name;

    TypeOfProduction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
