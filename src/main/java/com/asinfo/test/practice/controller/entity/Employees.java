package com.asinfo.test.practice.controller.entity;

import com.asinfo.test.practice.controller.enums.IdentificationType;
import com.asinfo.test.practice.controller.enums.StateEmployee;
import lombok.*;

import javax.persistence.*;
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

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private IdentificationType identificationType;

    private String identificationNumber;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateEmployee stateType;

    @JoinColumn(name = "id_department")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Department department;

    @JoinColumn(name = "id_charge")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Charges charges;

    @JoinColumn(name = "id_user")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_business")
    private Business business;
}
