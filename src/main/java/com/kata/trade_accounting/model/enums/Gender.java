package com.kata.trade_accounting.model.enums;

public enum Gender {
    MAN("Мужская"),
    WOMAN("Женская"),
    CHILD("Детская"),
    UNISEX("Унисекс");

    private final String name;

    Gender(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
