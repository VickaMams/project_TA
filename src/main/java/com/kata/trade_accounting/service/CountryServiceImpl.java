package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CountryDTO;
import com.kata.trade_accounting.exception.CountryNotFoundException;
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
        return countryMapper.toDto(countryRepository.findById(id).orElse(null));
    }

    @Override
    public void save(Country country) {
        countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(String.format("Warehouse with id=%s not found", id)));
        country.setRemoved(true);
        countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public CountryDTO update(CountryDTO countryDTO, Long id) {
        countryDTO.setId(id);
        return countryDTO;
    }
}
