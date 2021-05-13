package com.asinfo.test.practice.controller.entity;

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

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateEmployee stateType;

    @MapsId
    @JoinColumn(name = "id_department")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Department department;
}
