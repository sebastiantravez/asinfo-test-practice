package com.asinfo.test.practice.view;

import com.asinfo.test.practice.controller.entity.Users;
import com.asinfo.test.practice.controller.enums.IdentificationType;
import com.asinfo.test.practice.controller.enums.StateEmployee;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    private IdentificationType identificationType;

    private String identificationNumber;

    private Date date;

    private StateEmployee state;

    private UsersPresenter usersPresenter;

    private DepartmentPresenter departmentPresenter;
}
