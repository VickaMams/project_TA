package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.BasketDTO;
import com.kata.trade_accounting.model.Basket;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BasketMapper {
    private final ModelMapper mapper;

    public BasketMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public BasketDTO toDto(Basket basket) {
        return mapper.map(basket, BasketDTO.class);
    }

    public Basket toEntity(BasketDTO dto) {
        return mapper.map(dto, Basket.class);
    }
}
