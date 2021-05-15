package com.asinfo.test.practice.controller.entity;

import com.asinfo.test.practice.controller.enums.IdentificationType;
import com.asinfo.test.practice.controller.enums.StateEmployee;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.util.Date;
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

    @Column(name = "id_user")
    private UUID idUser;

    @Column(name = "id_charge")
    private UUID idCharge;

    @Column(name = "id_department")
    private UUID idDepartment;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private IdentificationType identificationType;

    private String identificationNumber;

    @Column(name = "salary")
    private BigDecimal salary;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateEmployee stateType;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private EmployeesDiscriminate employeesDiscriminate;

    @ManyToOne
    @JoinColumn(name = "id_business")
    private Business business;
}
