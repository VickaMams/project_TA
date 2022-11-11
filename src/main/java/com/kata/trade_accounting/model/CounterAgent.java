package com.kata.trade_accounting.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CounterAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String phoneNumber;
    private String fax;
    private String email;
    private String factualAddress;
    private String addressComment;

    private String comment;
    private String code;
    private String externalCode;

    /*
     TODO: реализовать эти поля

    private List<LawDetails> lawDetails;
    private List<Discount> discounts;
    private List<Employee> employees;       // поле "Контактные лица"
    private List<AccessEntry> accessEntry;  // поле "Доступ"

    */


}
