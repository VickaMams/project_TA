package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.WareHouse;

import java.util.List;

public interface WareHouseService {
    List<WareHouse> findAll();
    WareHouse findById(Long id);
    WareHouse save(WareHouse wareHouse);
    void deleteById(Long id);
    WareHouse update(WareHouse wareHouse);
}
