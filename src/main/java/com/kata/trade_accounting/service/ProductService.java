package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO getById(Long id);

    ProductDTO save(ProductDTO productDTO);

    void deleteById(Long id);

    ProductDTO update(ProductDTO productDTO);
}