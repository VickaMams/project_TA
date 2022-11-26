package com.kata.trade_accounting.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "LegalEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String shortName;

    @Column(name = "code", unique = true)
    private String code;

    private String phone;

    private String fax;

    private String email;

    private boolean nds;

    private String commentToAddress;

    private String director;

    private String positionOfTheHead;

    private String chiefAccountant;

    private String idFsrar;

    private String ipUtm;

    private String port;

    private boolean removed;

    @Lob
    @Column(name = "boss_sign_pic")
    private byte[] bossSinPic;

    @Lob
    @Column(name = "stamp_pic")
    private byte[] stampPic;

    @Lob
    @Column(name = "logo_pic")
    private byte[] logoPic;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private LawDetails lawDetails;

//    OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//    @JoinColumn (name = "id")
//    private Address factAddress;


}
