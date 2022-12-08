package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.LegalEntityRresponseDto;
import com.kata.trade_accounting.dto.LegalEntityRequestDto;
import com.kata.trade_accounting.exception.NotFoundByIdException;
import com.kata.trade_accounting.mapper.LegalEntityDtoMapper;
import com.kata.trade_accounting.mapper.LegalEntityMapper;
import com.kata.trade_accounting.repository.LegalEntityDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalEntityServiceImpl implements LegalEntityService {

    private final LegalEntityDao legalEntityDao;
    private final LegalEntityDtoMapper legalEntityDtoMapper;
    private final LegalEntityMapper legalEntityMapper;

    public LegalEntityServiceImpl(LegalEntityDao legalEntityDao, LegalEntityDtoMapper legalEntityDtoMapper, LegalEntityMapper legalEntityMapper) {
        this.legalEntityDao = legalEntityDao;
        this.legalEntityDtoMapper = legalEntityDtoMapper;
        this.legalEntityMapper = legalEntityMapper;
    }


    @Override
    public List<LegalEntityRresponseDto> findAll() {

        return legalEntityDao.findAll().
                stream().map(legalEntityDtoMapper::toLegalEntityDto).
                toList();
    }

    @Override
    public void addLegalEntity(LegalEntityRequestDto legalEntityRequestDto) {
        legalEntityDao.saveAndFlush(legalEntityMapper.toLegalEntity(legalEntityRequestDto));
    }

    @Override
    public void removeLegalEntityById(Long id) {
        if (findById(id) != null) {
            findById(id).setRemoved(true);
        } else {
            throw new NotFoundByIdException("Юридическое лицо не найдено");
        }
    }

    @Override
    public LegalEntityRresponseDto findById(Long id) {
        return legalEntityDtoMapper.toLegalEntityDto(legalEntityDao.findById(id).orElse(null));
    }

}
