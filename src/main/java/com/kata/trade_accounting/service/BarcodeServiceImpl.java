package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.BarcodeDTO;
import com.kata.trade_accounting.dto.GroupDTO;

import com.kata.trade_accounting.exception.BarcodeNotFoundException;
import com.kata.trade_accounting.exception.IdNotFoundException;

import com.kata.trade_accounting.mapper.BarcodeMapper;
import com.kata.trade_accounting.model.Barcode;
import com.kata.trade_accounting.repository.BarcodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class BarcodeServiceImpl implements BarcodeService {

    private final BarcodeRepository repository;

    private final BarcodeMapper mapper;

    @Override
    public List<BarcodeDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public BarcodeDTO getById(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new BarcodeNotFoundException(String.format("Barcode with id=%s not found", id))));
    }

    @Override
    public BarcodeDTO save(BarcodeDTO barcodeDTO) {
        repository.save(mapper.toEntity(barcodeDTO));
        return barcodeDTO;
    }

    @Override
    public void deleteById(Long id) {
        int i = repository.setRemovedTrue(id);
        if (i == 0) {
            throw new BarcodeNotFoundException(String.format("Product with id=%s not found", id));
        }
    }

    @Override
    public BarcodeDTO update(BarcodeDTO barcodeDTO) {
        Barcode barcode = repository.findById(barcodeDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("No such product with ID " + barcodeDTO.getId()));
        if (barcode.isRemoved()) {
            throw new IdNotFoundException("Product was deleted" + barcode.getId());
        }
        repository.save(mapper.toEntity(barcodeDTO));
        return barcodeDTO;
    }
}
