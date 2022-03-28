package com.computacenter.knontakt.kd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
public class MemberDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<RoleDAO> roles;

    @NotBlank(message = "Firstname is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    private String description;
}
