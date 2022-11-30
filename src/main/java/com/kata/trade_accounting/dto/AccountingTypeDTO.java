package com.kata.trade_accounting.dto;

import com.kata.trade_accounting.model.AccountingTypeSelection;
import com.kata.trade_accounting.model.PersonalProtectiveEquipmentName;
import com.kata.trade_accounting.model.PersonalProtectiveEquipmentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class AccountingTypeDTO {
    private Long id;

    private AccountingTypeSelection selection;
    private PersonalProtectiveEquipmentName equipmentName;
    private PersonalProtectiveEquipmentType equipmentType;

    private String productTypeCode;
    private Double tareCapacity;
    private Double alcoholStrength;
    private boolean taxMark;
    private String EGAIScodes;
    private Long productId;
}
