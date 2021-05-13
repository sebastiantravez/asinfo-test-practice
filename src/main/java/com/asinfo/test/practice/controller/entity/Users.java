package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Employees employees;
}
