package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.UnitsOfMeasurementDTO;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.exception.LawDetailsNotFoundException;
import com.kata.trade_accounting.exception.ModelDeletedException;
import com.kata.trade_accounting.mapper.UnitsOfMeasurementMapper;
import com.kata.trade_accounting.model.UnitsOfMeasurement;
import com.kata.trade_accounting.repository.UnitsOfMeasurementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class UnitsOfMeasurementDTOServiceImpl implements UnitsOfMeasurementDTOService {
    private final UnitsOfMeasurementRepository unitsOfMeasurementRepository;
    private final UnitsOfMeasurementMapper mapper;

    @Override
    public List<UnitsOfMeasurementDTO> findAll() {
        return unitsOfMeasurementRepository.findAll().stream()
                .filter(Predicate.not(UnitsOfMeasurement::isRemoved)).map(mapper::toDto).toList();
    }

    @Override
    public UnitsOfMeasurementDTO findById(Long id) throws IdNotFoundException {
        UnitsOfMeasurement unitsOfMeasurement = unitsOfMeasurementRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("No such UnitsOfMeasurement with ID " + id));
        if (unitsOfMeasurement.isRemoved()) {
            throw new IdNotFoundException("UnitsOfMeasurement was deleted" + id);
        }
        return mapper.toDto(unitsOfMeasurement);
    }

    @Override
    @Transactional
    public UnitsOfMeasurementDTO save(UnitsOfMeasurementDTO unitsOfMeasurementDTO) {
        UnitsOfMeasurement unitsOfMeasurement = unitsOfMeasurementRepository.findById(unitsOfMeasurementDTO.getId()).orElse(null);
        if (unitsOfMeasurement != null) {
            if (unitsOfMeasurement.isRemoved()) {
                throw new ModelDeletedException("the UnitsOfMeasurement with this ID" + unitsOfMeasurementDTO.getId() + " has been deleted");
            } else {
                throw new IdNotFoundException("this ID" + unitsOfMeasurementDTO.getId() + " is already in use ");
            }
        }
        unitsOfMeasurementRepository.save(mapper.toEntity(unitsOfMeasurementDTO));
        return unitsOfMeasurementDTO;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        int i = unitsOfMeasurementRepository.setRemovedTrue(id);
        if (i == 0) {
            throw new LawDetailsNotFoundException(String.format("UnitsOfMeasurement with id=%s not found", id));
        }
    }

    @Override
    @Transactional
    public UnitsOfMeasurementDTO update(UnitsOfMeasurementDTO unitsOfMeasurementDTO) {
        UnitsOfMeasurement unitsOfMeasurement = unitsOfMeasurementRepository.findById(unitsOfMeasurementDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("No such UnitsOfMeasurement with ID " + unitsOfMeasurementDTO.getId()));
        if (unitsOfMeasurement.isRemoved()) {
            throw new IdNotFoundException("UnitsOfMeasurement was deleted" + unitsOfMeasurementDTO.getId());
        }
        unitsOfMeasurementRepository.save(mapper.toEntity(unitsOfMeasurementDTO));
        return unitsOfMeasurementDTO;
    }
}
