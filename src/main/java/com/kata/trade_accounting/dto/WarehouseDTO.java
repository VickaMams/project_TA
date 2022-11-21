package com.kata.trade_accounting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name="WarehouseDTO", description="DTO model of warehouse")
public class WarehouseDTO {
    @Schema(description = "Warehouse ID", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Warehouse name")
    private String name;
    @Schema(description = "Warehouse code")
    private String code;
    @Schema(description = "Warehouse address")
    private String address;
    @Schema(description = "Comment to the warehouse address")
    private String commentForAddress;
    @Schema(description = "Comment")
    private String comment;
}
