package com.kata.trade_accounting.model.enums;

public enum Age {
    FOR_ADULT("Взрослое"),
    FOR_СHILD("Детское"),
    WITHOUT_AGE("Без возраста");

    private final String name;

    Age(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
