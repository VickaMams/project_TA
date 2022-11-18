package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.WarehouseDTO;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.exception.ModelDeletedException;
import com.kata.trade_accounting.mapper.WarehouseMapper;
import com.kata.trade_accounting.model.Warehouse;
import com.kata.trade_accounting.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class WarehouseDTOServiceImpl implements WarehouseDTOService {
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper mapper;

    @Override
    public List<WarehouseDTO> findAll() {
        return warehouseRepository.findAll().stream()
                .filter(Predicate.not(Warehouse::isRemove)).map(mapper::toDto).toList();
    }

    @Override
    public WarehouseDTO findById(Long id) throws IdNotFoundException {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("No such warehouse with ID " + id));
        if (warehouse.isRemove()) {
            throw new IdNotFoundException("Warehouse was deleted" + id);
        }
        return mapper.toDto(warehouse);
    }

    @Override
    @Transactional
    public WarehouseDTO save(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(warehouseDTO.getId()).orElse(null);
        if (warehouse != null) {
            if (warehouse.isRemove()){
                throw new ModelDeletedException("the model with this ID" + warehouseDTO.getId() + " has been deleted");
            } else {
                throw new IdNotFoundException("this ID" + warehouseDTO.getId() + " is already in use ");
            }
        }
        warehouseRepository.save(mapper.toEntity(warehouseDTO));
        return warehouseDTO;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("No such warehouse with ID " + id));
        if (warehouse.isRemove()) {
            throw new IdNotFoundException("Warehouse was deleted" + id);
        }
        warehouse.setRemove(true);
        warehouseRepository.save(warehouse);
    }

    @Override
    @Transactional
    public WarehouseDTO update(WarehouseDTO wareHouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(wareHouseDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("No such warehouse with ID " + wareHouseDTO.getId()));
        if (warehouse.isRemove()) {
            throw new IdNotFoundException("Warehouse was deleted" + wareHouseDTO.getId());
        }
        warehouseRepository.save(mapper.toEntity(wareHouseDTO));
        return wareHouseDTO;
    }
}
