package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "department")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "id_department")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDepartment;

    @Column(name = "name_department")
    private String nameDepartment;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "department")
    private Employees employees;
}
