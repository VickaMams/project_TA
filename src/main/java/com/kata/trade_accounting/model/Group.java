package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean removed;
}
