package com.kata.trade_accounting.dto;

import com.kata.trade_accounting.model.SalesChannelType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class SalesChannelDTO {
    private Long id;

    private String name;
    private SalesChannelType type;
    private String description;
}
