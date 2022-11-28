package com.kata.trade_accounting.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CounterAgentNotFoundException.class)
    public ResponseEntity<String> counterAgentNotFoundException(CounterAgentNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNotFoundException(IdNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return "ID_not_found";
    }

    @ExceptionHandler(ModelDeletedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleModelDeletedException(ModelDeletedException exception) {
        log.error(exception.getMessage(), exception);
        return "ModelDeleted";
    }

    @ExceptionHandler(value = GroupNotFoundException.class)
    public ResponseEntity<String> groupNotFoundException(GroupNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CurrencyNotFoundException.class)
    public ResponseEntity<String> currencyNotFoundException(CurrencyNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
