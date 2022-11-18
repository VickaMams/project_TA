package com.kata.trade_accounting.exception;

public class AlreadyInUseException extends RuntimeException{
    public AlreadyInUseException(String message) {
        super(message);
    }
}
