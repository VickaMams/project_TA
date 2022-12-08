package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.ProductPackagingDto;
import com.kata.trade_accounting.model.ProductPackaging;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductPackagingDtoMapper extends Converter<ProductPackaging, ProductPackagingDto> {

    ProductPackagingDto toProductPackagingDto(ProductPackaging productPackaging);
}
