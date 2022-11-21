package com.kata.trade_accounting.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CounterAgent {
    private boolean removed;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Database-generated counter agent ID")
    private Long id;
    @ApiModelProperty(notes = "Name of the legal entity", required = true)
    private String name;

    @ApiModelProperty(notes = "Phone number")
    private String phoneNumber;
    @ApiModelProperty(notes = "Fax number")
    private String fax;
    @ApiModelProperty(notes = "Email address")
    private String email;
    @ApiModelProperty(notes = "Factual address")
    private String factualAddress;
    @ApiModelProperty(notes = "Comment related to address")
    private String addressComment;

    @ApiModelProperty(notes = "Comment related to this counter agent")
    private String comment;
    @ApiModelProperty(notes = "Code of this counter agent")
    private String code;
    @ApiModelProperty(notes = "External code")
    private String externalCode;

    /*
     TODO: реализовать эти поля

    private List<LawDetails> lawDetails;
    private List<Discount> discounts;
    private List<Employee> employees;       // поле "Контактные лица"
    private List<AccessEntry> accessEntry;  // поле "Доступ"

    */


}
