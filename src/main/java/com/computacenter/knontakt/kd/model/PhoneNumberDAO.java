package com.computacenter.knontakt.kd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "phonenumber")
@Getter
@Setter
public class PhoneNumberDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;

    @NotBlank
    private String number;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ContactType contactType;

}
