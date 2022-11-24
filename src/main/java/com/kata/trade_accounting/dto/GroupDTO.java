package com.kata.trade_accounting.dto;

import com.kata.trade_accounting.model.Nds;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Component
@Data
public class GroupDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;
    private String description;
    private String code;
    private String externalCode;
    @Transient
    private Nds NDS;
    private String taxationSystem;
    private String employee;
    private String department;
    private boolean sharedAccess;
    private boolean removed;
}
