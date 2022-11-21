package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country getById(Long id);

    void save(Country country);

    void deleteById(Long id);

    Country update(Country country);
 }
