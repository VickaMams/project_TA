package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.BasketDTO;
import com.kata.trade_accounting.dto.UnitsOfMeasurementDTO;

import java.util.List;

public interface BasketService {
    List<BasketDTO> findAll();

    BasketDTO findById(Long id);

    BasketDTO save(BasketDTO basketDTO);

    void deleteById(Long id);

    BasketDTO update(BasketDTO basketDTO);
}
