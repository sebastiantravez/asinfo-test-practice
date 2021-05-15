package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.entity.*;
import com.asinfo.test.practice.controller.enums.ChargesType;
import com.asinfo.test.practice.controller.enums.StateEmployee;
import com.asinfo.test.practice.controller.repository.*;
import com.asinfo.test.practice.service.EmployeesService;
import com.asinfo.test.practice.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ChargesRepository chargesRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    EmployeeDiscriminateRepository employeeDiscriminateRepository;

    @Override
    public void saveEmployees(EmployeesPresenter employeesPresenter) {

        Optional<Business> business = businessRepository.findById(employeesPresenter.getBusinessPresenter().getIdBusiness());
        Users userEmployee = Users.builder()
                .userName(employeesPresenter.getIdentificationNumber())
                .password(employeesPresenter.getIdentificationNumber())
                .build();
        usersRepository.save(userEmployee);
        Users users1 = usersRepository.findByUserNameAndPassword(userEmployee.getUserName(), userEmployee.getPassword());
        Optional<Department> department = departmentsRepository.findById(employeesPresenter.getDepartmentPresenter().getIdDepartment());
        Charges charges = chargesRepository.findByName(employeesPresenter.getChargesPresenter().getName());

        Employees employeeSave = Employees.builder()
                .business(business.get())
                .department(department.get())
                .users(users1)
                .charges(charges)
                .fullName(employeesPresenter.getFullName())
                .identificationType(employeesPresenter.getIdentificationType())
                .identificationNumber(employeesPresenter.getIdentificationNumber())
                .salary(employeesPresenter.getSalary())
                .date(employeesPresenter.getDate())
                .stateType(StateEmployee.ACTIVE)
                .build();

        employeesRepository.save(employeeSave);

        Employees employeeSupervisor = employeesRepository.findByIdUser(employeesPresenter.getUsersPresenter().getIdUser());
        Employees employee = employeesRepository.findByIdentificationTypeAndIdentificationNumber(
                employeesPresenter.getIdentificationType(),
                employeesPresenter.getIdentificationNumber());
        EmployeesDiscriminate employeesDiscriminate = EmployeesDiscriminate.builder()
                .idEmployee(employee.getIdEmployee())
                .idSupervisor(employeeSupervisor.getIdEmployee())
                .build();

        employeeDiscriminateRepository.save(employeesDiscriminate);

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
                                .userName(item.getUsers().getUserName())
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
