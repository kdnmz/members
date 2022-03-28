package com.computacenter.knontakt.kd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String street;

    @Column(name = "house_number")
    @NotBlank
    private String houseNumber;

    @NotBlank
    private String country;

    @NotBlank
    private String zip;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ContactType contactType;

}
