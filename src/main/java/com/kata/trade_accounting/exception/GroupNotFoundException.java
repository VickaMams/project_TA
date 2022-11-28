package com.kata.trade_accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupNotFoundException extends NullPointerException {

    public GroupNotFoundException(String message) {
        super(message);
    }
}
