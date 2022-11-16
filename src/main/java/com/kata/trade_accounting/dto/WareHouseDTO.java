package com.kata.trade_accounting.dto;

import lombok.Data;

@Data
public class WareHouseDTO {
    private Long id;
    private String name;
    private String code;
    private String address;
    private String sharedAccess;
    private String ownerDepartment;
    private String ownerEmployee;
}
