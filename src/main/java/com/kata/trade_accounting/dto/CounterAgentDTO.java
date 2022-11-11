package com.kata.trade_accounting.dto;

import lombok.Data;

@Data
public class CounterAgentDTO {

    enum Status {
        NEW,
        OFFER_SENT,
        NEGOTIATING,
        DEAL_SIGNED,
        DEAL_REJECTED
    }

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

    private List<LawDetailsDTO> lawDetails;
    private List<DiscountDTO> discounts;
    private List<EmployeeDTO> employees;            // поле "Контактные лица"
    private List<AccessEntryDTO> accessEntryDTO;    // поле "Доступ"

    */
}
