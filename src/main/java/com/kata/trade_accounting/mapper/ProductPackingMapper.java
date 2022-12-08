package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.ProductPackagingDto;
import com.kata.trade_accounting.model.ProductPackaging;
import jdk.incubator.vector.VectorOperators;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductPackingMapper extends VectorOperators.Conversion<ProductPackagingDto, ProductPackaging> {
     ProductPackaging toProductPackaging(ProductPackagingDto productPackagingDto);
}
