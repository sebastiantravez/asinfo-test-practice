package com.asinfo.test.practice.view;

import com.asinfo.test.practice.controller.entity.Business;
import com.asinfo.test.practice.controller.entity.Charges;
import com.asinfo.test.practice.controller.entity.Roles;
import com.asinfo.test.practice.controller.entity.Users;
import com.asinfo.test.practice.controller.enums.IdentificationType;
import com.asinfo.test.practice.controller.enums.StateEmployee;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
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

    private String email;

    private IdentificationType identificationType;

    private String identificationNumber;

    private Date date;

    private StateEmployee state;

    private BusinessPresenter businessPresenter;

    private ChargesPresenter chargesPresenter;

    private UsersPresenter usersPresenter;

    private DepartmentPresenter departmentPresenter;

    private byte[] pdf;
}
