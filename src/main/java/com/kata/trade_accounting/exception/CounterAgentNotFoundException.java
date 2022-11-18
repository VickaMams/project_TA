package com.kata.trade_accounting.exception;

public class CounterAgentNotFoundException extends RuntimeException {
    public CounterAgentNotFoundException(String msg) {
        super(msg);
    }

    public CounterAgentNotFoundException(Exception cause) {
        super(cause);
    }
}
