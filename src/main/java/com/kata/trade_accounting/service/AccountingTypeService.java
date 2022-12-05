package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.AccountingTypeDTO;

import java.util.List;

public interface AccountingTypeService {

    List<AccountingTypeDTO> findAll();

    AccountingTypeDTO getById(Long id);

    AccountingTypeDTO save(AccountingTypeDTO dto);

    void deleteById(Long id);

    AccountingTypeDTO edit(Long id, AccountingTypeDTO dto);

}
