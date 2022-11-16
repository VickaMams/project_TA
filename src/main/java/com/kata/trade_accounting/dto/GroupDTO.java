package com.kata.trade_accounting.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GroupDTO {

    private Long id;
    private String groupName;
    private String description;
    private String code;
    private String externalCode;
    private String NDS;
    private String taxationSystem;
    private String employee;
    private String department;
    private boolean sharedAccess;
}
