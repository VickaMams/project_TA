package com.kata.trade_accounting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UnitsOfMeasurement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitsOfMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shortName;
    private String fullName;
    private String code;

    private boolean removed;
}
