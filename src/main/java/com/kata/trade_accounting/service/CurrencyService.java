package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CurrencyDTO;

import java.util.List;

public interface CurrencyService {

    List<CurrencyDTO> findAll();

    CurrencyDTO getById(Long id);

    CurrencyDTO save(CurrencyDTO dto);

    void deleteById(Long id);

    CurrencyDTO edit(Long id, CurrencyDTO dto);
}
