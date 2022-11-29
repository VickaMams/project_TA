package com.kata.trade_accounting.dto;

import com.kata.trade_accounting.model.Document;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "BasketDTO", description = "DTO model of Basket")
public class BasketDTO {
    @Schema(description = "Basket ID", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Basket document List")
    private List<Document> documentList;

}
