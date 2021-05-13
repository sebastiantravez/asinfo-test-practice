package com.asinfo.test.practice.view;

import com.asinfo.test.practice.controller.enums.StateEmployee;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "idEmployee")
@ToString(of = "idEmployee")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesPresenter {

    private UUID idEmployee;

    private String fullName;

    private BigDecimal salary;

    private Date date;

    private StateEmployee state;

    private DepartmentPresenter departmentPresenter;
}
