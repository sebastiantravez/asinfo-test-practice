package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
}
