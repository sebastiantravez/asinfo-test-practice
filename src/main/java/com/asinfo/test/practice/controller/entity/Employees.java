package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    @Id
    @Column(name = "id_employee")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmployee;

    @Column(name = "full_name")
    private String fullName;

    @MapsId
    @JoinColumn(name = "id_department")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Department department;
}
