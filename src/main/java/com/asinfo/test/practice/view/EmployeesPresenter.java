package com.asinfo.test.practice.view;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "id_employee")
@ToString(of = "id_employee")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesPresenter {

    private UUID idEmployee;

    private String fullName;
}
