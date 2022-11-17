package com.kata.trade_accounting.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NdsDto {

    private Long id;

    private Integer ndsValue;

    private String comment;

}
