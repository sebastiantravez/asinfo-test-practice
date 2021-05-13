package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "charges")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Charges {

    @Id
    @Column(name = "id_charge")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCharge;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "charges")
    private Employees employees;
}
