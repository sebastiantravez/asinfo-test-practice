package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idRol;

    @Column(name = "name")
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "roles", cascade = { CascadeType.ALL })
    private List<Users> users = new ArrayList<>();
}
