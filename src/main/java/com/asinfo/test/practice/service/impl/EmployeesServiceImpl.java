package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.entity.Business;
import com.asinfo.test.practice.controller.entity.Charges;
import com.asinfo.test.practice.controller.entity.Employees;
import com.asinfo.test.practice.controller.entity.Roles;
import com.asinfo.test.practice.controller.repository.EmployeesRepository;
import com.asinfo.test.practice.service.EmployeesService;
import com.asinfo.test.practice.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Override
    public void saveEmployees(EmployeesPresenter employeesPresenter) {
        Employees employees = Employees.builder()
                .fullName(employeesPresenter.getFullName())
                .build();
        employeesRepository.save(employees);
    }

    @Override
    public List<EmployeesPresenter> getAllEmployees() {
        return employeesRepository.findByAllEmployees().stream()
                .filter(Objects::nonNull)
                .map(item -> EmployeesPresenter.builder()
                        .idEmployee(item.getIdEmployee())
                        .fullName(item.getFullName())
                        .identificationType(item.getIdentificationType())
                        .identificationNumber(item.getIdentificationNumber())
                        .salary(item.getSalary())
                        .date(item.getDate())
                        .state(item.getStateType())
                        .businessPresenter(BusinessPresenter.builder()
                                .businessName(item.getBusiness().getBusinessName())
                                .build())
                        .usersPresenter(UsersPresenter.builder()
                                .user(item.getUsers().getUser())
                                .password(item.getUsers().getPassword())
                                .usersRolesPresenters(item.getUsers().getRoles().stream()
                                        .filter(Objects::nonNull).map(item1 -> UsersRolesPresenter.builder()
                                                .name(item1.getName())
                                                .build()
                                        ).collect(Collectors.toList()))
                                .build())
                        .chargesPresenter(ChargesPresenter.builder()
                                .name(item.getCharges().getName())
                                .build())
                        .departmentPresenter(DepartmentPresenter.builder()
                                .nameDepartment(item.getDepartment().getNameDepartment())
                                .build())
                        .build()).collect(Collectors.toList());

    }

}
