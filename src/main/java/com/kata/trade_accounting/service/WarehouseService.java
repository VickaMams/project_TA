package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> findAll();
    Warehouse findById(Long id);
    Warehouse save(Warehouse warehouse);
    void deleteById(Long id);
    Warehouse update(Warehouse warehouse);
}
