package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.SalesChannelDTO;
import com.kata.trade_accounting.model.SalesChannel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SalesChannelMapper {

    private final ModelMapper mapper;

    public SalesChannelDTO toDto(SalesChannel salesChannel) {
        return mapper.map(salesChannel, SalesChannelDTO.class);
    }

    public SalesChannel toEntity(SalesChannelDTO dto) {
        return mapper.map(dto, SalesChannel.class);
    }
}
