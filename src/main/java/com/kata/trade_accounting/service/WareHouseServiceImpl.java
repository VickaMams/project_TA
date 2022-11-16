package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.WareHouse;
import com.kata.trade_accounting.repository.WareHouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseServiceImpl implements WareHouseService{
    private final WareHouseRepository wareHouseRepository;

    public WareHouseServiceImpl(WareHouseRepository wareHouseRepository) {
        this.wareHouseRepository = wareHouseRepository;
    }

    @Override
    public List<WareHouse> findAll() {
        return wareHouseRepository.findAll();
    }

    @Override
    public WareHouse findById(Long id) {
        return wareHouseRepository.getReferenceById(id);
    }

    @Override
    public WareHouse save(WareHouse wareHouse) {
        return wareHouseRepository.save(wareHouse);
    }

    @Override
    public void deleteById(Long id) {
        wareHouseRepository.deleteById(id);
    }

    @Override
    public WareHouse update(WareHouse wareHouse) {
        return wareHouseRepository.save(wareHouse);
    }
}
