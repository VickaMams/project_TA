package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.ProductPackagingDto;

import java.util.List;

public interface ProductPackagingService {

    List<ProductPackagingDto> findAll();

    void addProductPackaging(ProductPackagingDto productPackagingDto);

    void removeProductPackaging(Long id);

    ProductPackagingDto findById(Long id);

}
