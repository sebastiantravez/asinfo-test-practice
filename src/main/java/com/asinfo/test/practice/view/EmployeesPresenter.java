package com.asinfo.test.practice.view;

import lombok.*;

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

    private DepartmentPresenter departmentPresenter;
}
