package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.TypeOfProductDto;
import com.kata.trade_accounting.model.TypeOfProduct;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TypeOfProductMapper extends Converter<TypeOfProductDto, TypeOfProduct> {
    TypeOfProduct toTypeOfProduct(TypeOfProductDto typeOfProductDto);
}
