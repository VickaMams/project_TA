package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.BarcodeDTO;
import com.kata.trade_accounting.model.Barcode;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BarcodeMapper {
    private final ModelMapper mapper;

    public BarcodeDTO toDTO(Barcode barcode) {
        return mapper.map(barcode, BarcodeDTO.class);
    }

    public Barcode toEntity(BarcodeDTO barcodeDTO) {
        return mapper.map(barcodeDTO, Barcode.class);
    }
}
