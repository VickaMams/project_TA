package com.kata.trade_accounting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="UnitsOfMeasurementDTO", description="DTO model of UnitsOfMeasurement")
public class UnitsOfMeasurementDTO {
    @Schema(description = "UnitsOfMeasurement ID", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "UnitsOfMeasurement name")
    private String shortName;
    @Schema(description = "UnitsOfMeasurement name")
    private String fullName;
    @Schema(description = "UnitsOfMeasurement code")
    private String code;

}
