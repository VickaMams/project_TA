package com.kata.trade_accounting.exception;

public class BarcodeNotFoundException extends RuntimeException {

    public BarcodeNotFoundException(String message) {
        super(message);
    }

    public BarcodeNotFoundException(Exception cause) {
        super(cause);
    }
}
