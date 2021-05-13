package com.asinfo.test.practice.controller.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "department")
@Getter
@Setter
@Builder
public class Department {

    @Id
    @Column(name = "id_department")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name_department")
    private String nameDepartment;

    @MapsId
    @JoinColumn(name = "id_employee")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Employees employees;
}
