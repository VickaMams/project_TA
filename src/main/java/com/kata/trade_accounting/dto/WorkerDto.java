package com.kata.trade_accounting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDto {

    private Long id;

    private String name;

    private String last_name;

    private String patronymic;

    private String telephone;

    private String email;

    private String login;

    private String description;

    //private String role; // need an entity Role to implement



}
