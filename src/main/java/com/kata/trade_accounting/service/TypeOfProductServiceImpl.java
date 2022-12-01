package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.TypeOfProductDto;
import com.kata.trade_accounting.exception.NotFoundByIdException;
import com.kata.trade_accounting.mapper.TypeOfProductDtoMapper;
import com.kata.trade_accounting.mapper.TypeOfProductMapper;
import com.kata.trade_accounting.repository.TypeOfProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfProductServiceImpl implements TypeOfProductService {

    private final TypeOfProductDao typeOfProductDao;

    private final TypeOfProductDtoMapper typeOfProductDtoMapper;

    private final TypeOfProductMapper typeOfProductMapper;

    public TypeOfProductServiceImpl(TypeOfProductDao typeOfProductDao, TypeOfProductDtoMapper typeOfProductDtoMapper, TypeOfProductMapper typeOfProductMapper) {
        this.typeOfProductDao = typeOfProductDao;
        this.typeOfProductDtoMapper = typeOfProductDtoMapper;
        this.typeOfProductMapper = typeOfProductMapper;
    }


    @Override
    public List<TypeOfProductDto> findAll() {
        return typeOfProductDao.findAll()
                .stream().map(typeOfProductDtoMapper::toTypeOfProductDto)
                .toList();
    }

    @Override
    public void addTypeOfProduct(TypeOfProductDto typeOfProductDto) {
        typeOfProductDao.saveAndFlush(typeOfProductMapper.toTypeOfProduct(typeOfProductDto));
    }

    @Override
    public void removeTypeOfProductById(Long id) {
        if (typeOfProductDao.findById(id) != null) {
            findById(id).setRemoved(true);
        } else {
            throw new NotFoundByIdException("Тип продукцуии не найден");
        }
    }

    @Override
    public TypeOfProductDto findById(Long id) {
        return typeOfProductDtoMapper.toTypeOfProductDto(typeOfProductDao.findById(id).orElse(null));
    }
}
