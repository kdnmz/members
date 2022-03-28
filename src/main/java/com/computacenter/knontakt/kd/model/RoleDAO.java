package com.computacenter.knontakt.kd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Role is mandatory")
    private String role;

    private String description;
}
