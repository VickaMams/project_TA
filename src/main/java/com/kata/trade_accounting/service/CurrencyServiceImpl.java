package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CurrencyDTO;
import com.kata.trade_accounting.exception.CurrencyNotFoundException;
import com.kata.trade_accounting.mapper.CurrencyMapper;
import com.kata.trade_accounting.model.Currency;
import com.kata.trade_accounting.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl  implements CurrencyService{

    private final CurrencyRepository repository;

    private final CurrencyMapper mapper;

    @Override
    public List<CurrencyDTO> findAll() {
        return repository.findAll().stream()
                .filter(Predicate.not(Currency::isRemoved))
                .map(mapper::toDto).toList();
    }

    @Override
    public CurrencyDTO getById(Long id) {
        Optional<Currency> currency = repository.findById(id);
        if (currency.isPresent()){
            return mapper.toDto(currency.get());
        } else {
            throw new CurrencyNotFoundException(String.format("Currency with id =%s not found", id));
        }
    }

    @Override
    @Transactional
    public CurrencyDTO save(CurrencyDTO dto) {
        Currency currency = repository.save(mapper.toEntity(dto));
        currency.setRemoved(false);
        return mapper.toDto(currency);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        int i = repository.setRemovedTrue(id);
        if (i == 0) {
            throw new CurrencyNotFoundException(String.format("Currency with id =%s not found", id));
        }
    }

    @Override
    @Transactional
    public CurrencyDTO edit(Long id, CurrencyDTO dto) {
        Optional<Currency> currency = repository.findById(id);
        if (currency.isPresent()){
            if (currency.get().isRemoved()){
                throw new CurrencyNotFoundException(String.format("Currency with id =%s already deleted", id));
            }
            dto.setId(id);
            return save(dto);
        } else {
            throw new CurrencyNotFoundException(String.format("Currency with id =%s not found", id));
        }
    }
}
