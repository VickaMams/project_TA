package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CountryDTO;
import com.kata.trade_accounting.exception.CountryNotFoundException;
import com.kata.trade_accounting.exception.LawDetailsNotFoundException;
import com.kata.trade_accounting.mapper.CountryMapper;
import com.kata.trade_accounting.model.Country;
import com.kata.trade_accounting.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CountryDTO> findAll() {
        return countryRepository.findAll().stream().
                map(countryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CountryDTO findById(Long id) {
        return countryMapper.toDto(countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(String.format("Countries with id=%s not found", id))));
    }

    @Override
    public void save(CountryDTO countryDTO) {
        countryRepository.save(countryMapper.toModel(countryDTO));
    }

    @Override
    public void deleteById(Long id) {
        int i = countryRepository.setRemovedTrue(id);
        if (i == 0) {
            throw new CountryNotFoundException(String.format("Countries with id=%s not found", id));
        }
    }

    @Override
    public CountryDTO update(CountryDTO countryDTO, Long id) {
        countryDTO.setId(id);
        save(countryDTO);
        return countryDTO;
    }
}
