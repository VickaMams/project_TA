package com.kata.trade_accounting.controller.mapper;

import com.kata.trade_accounting.dto.ProductDTO;
import com.kata.trade_accounting.model.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ProductMapper {

    private final ModelMapper mapper;

    public ProductDTO toDTO(Product product) {
        return mapper.map(product, ProductDTO.class);
    }

    public Product toEntity(ProductDTO productDTO) {
        return mapper.map(productDTO, Product.class);
    }
}