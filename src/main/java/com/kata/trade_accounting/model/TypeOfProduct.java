package com.kata.trade_accounting.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "type_of_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "tnved_ID")
    private Tnved tnved;

    private String model;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private TypeOfProduction typeOfProduction;

    @Enumerated(EnumType.STRING)
    private Age age;

    private boolean removed;
}
