package com.kata.trade_accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupNullPointerException extends NullPointerException {

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
