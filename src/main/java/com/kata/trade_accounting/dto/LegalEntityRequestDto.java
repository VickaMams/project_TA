package com.kata.trade_accounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityRequestDto {

    private Long id;

    @NotBlank(message = "Необходимо указать имя")
    private String shortName;

    private String code;

    private String phone;

    private String fax;

    @Email(message = "Email должен быть корректным адресом электронной почты")
    private String email;

    private boolean nds;

    private String commentToAddress;

    private String director;

    private String positionOfTheHead;

    private String chiefAccountant;

    private String idFsrar;

    private String ipUtm;

    private String port;

    private Long lawDetailsId;

    private byte[] bossSinPic;

    private byte[] stampPic;

    private byte[] logoPic;
}
