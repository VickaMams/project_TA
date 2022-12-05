package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.BarcodeDTO;

import java.util.List;

public interface BarcodeService {
    List<BarcodeDTO> findAll();

    BarcodeDTO getById(Long id);

    BarcodeDTO save(BarcodeDTO barcodeDTO);

    void deleteById(Long id);

    BarcodeDTO update(BarcodeDTO barcodeDTO);
}
