package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.AccountingTypeDTO;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.exception.ModelDeletedException;
import com.kata.trade_accounting.mapper.AccountingTypeMapper;
import com.kata.trade_accounting.model.AccountingType;
import com.kata.trade_accounting.repository.AccountingTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class AccountingTypeServiceImpl implements AccountingTypeService{

    private final AccountingTypeMapper mapper;

    private final AccountingTypeRepository repository;

    @Override
    public List<AccountingTypeDTO> findAll() {
        return repository.findAll().stream()
                .filter(Predicate.not(AccountingType::isRemoved))
                .map(mapper::toDto).toList();
    }

    @Override
    public AccountingTypeDTO getById(Long id) {
        Optional<AccountingType> accountingType = repository.findById(id);
        if (accountingType.isPresent()) {
            return mapper.toDto(accountingType.get());
        } else {
            throw new IdNotFoundException(String.format("Accounting Type with id = %s not found", id));
        }
    }

    @Override
    public AccountingTypeDTO getByProductId(Long id) {
        Optional<AccountingType> accountingType = repository.findByProductId(id);
        if (accountingType.isPresent()) {
            return mapper.toDto(accountingType.get());
        } else {
            throw new IdNotFoundException(String.format("Accounting Type with id = %s not found", id));
        }
    }

    @Override
    @Transactional
    public AccountingTypeDTO save(AccountingTypeDTO dto) {
        AccountingType accountingType = repository.save(mapper.toEntity(dto));
        return mapper.toDto(accountingType);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        int i = repository.setRemovedTrue(id);
        if (i == 0) {
            throw new IdNotFoundException(String.format("Accounting Type with id = %s not found", id));
        }
    }

    @Override
    @Transactional
    public AccountingTypeDTO edit(Long id, AccountingTypeDTO dto) {
        Optional<AccountingType> accountingType = repository.findById(id);
        if (accountingType.isPresent()) {
            if (accountingType.get().isRemoved()) {
                throw new ModelDeletedException(String.format("Accounting Type with id = %s already deleted", id));
            }
            dto.setId(id);
            return save(dto);
        } else {
            throw new IdNotFoundException(String.format("Accounting Type with id = %s not found", id));
        }
    }
}
