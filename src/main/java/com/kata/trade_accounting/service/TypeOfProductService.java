package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.TypeOfProductDto;
import com.kata.trade_accounting.model.TypeOfProduct;

import java.util.List;

public interface TypeOfProductService {

    List<TypeOfProductDto> findAll();

    void addTypeOfProduct(TypeOfProductDto typeOfProductDto);

    void removeTypeOfProductById(Long id);

    TypeOfProductDto findById(Long id);

}
