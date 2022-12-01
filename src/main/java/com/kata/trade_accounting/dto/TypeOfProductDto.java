package com.kata.trade_accounting.dto;

import com.kata.trade_accounting.model.Tnved;
import com.kata.trade_accounting.model.enums.Age;
import com.kata.trade_accounting.model.enums.Gender;
import com.kata.trade_accounting.model.enums.TypeOfProduction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfProductDto {


    private Long id;

    @NotBlank
    private String name;

    private Tnved tnved;

    private String model;

    private Gender gender;

    private TypeOfProduction typeOfProduction;

    private Age age;

    private boolean removed;
}
