package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employees_discriminate")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDiscriminate {
    @Id
    @Column(name = "id_employee")
    private UUID idEmployee;

    @Column(name = "id_supervisor")
    private UUID idSupervisor;

    @JoinColumn(name = "id_employee")
    @OneToOne(cascade = CascadeType.ALL)
    private Employees employees;

}
