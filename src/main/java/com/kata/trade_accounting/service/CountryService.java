package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CountryDTO;
import com.kata.trade_accounting.model.Country;

import java.util.List;

public interface CountryService {

    List<CountryDTO> findAll();

    CountryDTO findById(Long id);

    void save(Country country);

    void deleteById(Long id);

    CountryDTO update(CountryDTO countryDTO, Long id);
 }
