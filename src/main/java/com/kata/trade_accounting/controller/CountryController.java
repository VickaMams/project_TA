package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.service.CountryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


}
