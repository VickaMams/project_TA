package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.LegalEntityRresponseDto;
import com.kata.trade_accounting.dto.LegalEntityRequestDto;

import java.util.List;

public interface LegalEntityService {

    List<LegalEntityRresponseDto> findAll();

    void addLegalEntity(LegalEntityRequestDto legalEntityRequestDto);

    void removeLegalEntityById(Long id);

    LegalEntityRresponseDto findById(Long id);
}
