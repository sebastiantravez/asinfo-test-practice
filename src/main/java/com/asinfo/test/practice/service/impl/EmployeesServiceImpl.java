package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.entity.*;
import com.asinfo.test.practice.controller.enums.ChargesType;
import com.asinfo.test.practice.controller.enums.StateEmployee;
import com.asinfo.test.practice.controller.repository.*;
import com.asinfo.test.practice.service.EmployeesService;
import com.asinfo.test.practice.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.*;
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
    public EmployeesPresenter saveEmployees(EmployeesPresenter employeesPresenter) {
        try {
            Optional<Employees> employeeValidate = employeesRepository.findByIdentificationTypeAndIdentificationNumber(
                    employeesPresenter.getIdentificationType(),
                    employeesPresenter.getIdentificationNumber()
            );
            if (employeeValidate.isPresent()) {
                throw new ValidationException("Empleado con número de identificacón ya existe");
            }
            Optional<Employees> employeeValidateEmail = employeesRepository.findByEmail(employeesPresenter.getEmail());
            if (employeeValidateEmail.isPresent()) {
                throw new ValidationException("Empleado con email ya existe");
            }

            Optional<Business> business = businessRepository.findById(employeesPresenter.getBusinessPresenter().getIdBusiness());
            Users userEmployeeSave = Users.builder()
                    .userName(employeesPresenter.getIdentificationNumber())
                    .password(employeesPresenter.getIdentificationNumber())
                    .build();
            usersRepository.save(userEmployeeSave);
            Users userEmployee = usersRepository.findByUserNameAndPassword(userEmployeeSave.getUserName(), userEmployeeSave.getPassword());
            Optional<Department> department = departmentsRepository.findById(employeesPresenter.getDepartmentPresenter().getIdDepartment());
            Charges charges = chargesRepository.findByName(employeesPresenter.getChargesPresenter().getName());

            Employees employeeSave = Employees.builder()
                    .business(business.get())
                    .idDepartment(department.get().getIdDepartment())
                    .idUser(userEmployee.getIdUser())
                    .idCharge(charges.getIdCharge())
                    .idEmployee(charges.getIdCharge())
                    .fullName(employeesPresenter.getFullName())
                    .identificationType(employeesPresenter.getIdentificationType())
                    .identificationNumber(employeesPresenter.getIdentificationNumber())
                    .email(employeesPresenter.getEmail())
                    .salary(employeesPresenter.getSalary())
                    .date(employeesPresenter.getDate())
                    .stateType(StateEmployee.ACTIVE)
                    .build();

            employeesRepository.save(employeeSave);

            Optional<Employees> employee = employeesRepository.findByIdentificationTypeAndIdentificationNumber(
                    employeesPresenter.getIdentificationType(),
                    employeesPresenter.getIdentificationNumber());
            Employees employeeSupervisor = employeesRepository.findDataUsersByIdUser(employeesPresenter.getUsersPresenter().getIdUser());
            EmployeesDiscriminate employeesDiscriminate = EmployeesDiscriminate.builder()
                    .idEmployee(employee.get().getIdEmployee())
                    .idSupervisor(employeeSupervisor.getIdEmployee())
                    .build();

            employeeDiscriminateRepository.save(employeesDiscriminate);

            /*employeesPresenter.getUsersPresenter().getUsersRolesPresenters().forEach(item -> {
                UsersRoles usersRoles = UsersRoles.builder()
                        .idUser(employee.getIdUser())
                        .idRol(item.getIdRol())
                        .build();
                usersRolesRepository.save(usersRoles);
            });*/

            return employeesPresenter;
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }
    }

    @Override
    public List<EmployeesPresenter> getAllEmployees(UUID id) {
        Employees employeeSupervisor = employeesRepository.findDataUsersByIdUser(id);
        if (employeeSupervisor == null) {
            throw new ValidationException("No se encontraron registros");
        }
        return employeesRepository.findEmployeesBySupervisor(employeeSupervisor.getIdEmployee()).stream()
                .filter(Objects::nonNull)
                .map(item -> EmployeesPresenter.builder()
                        .idEmployee(item.getIdEmployee())
                        .fullName(item.getFullName())
                        .identificationType(item.getIdentificationType())
                        .identificationNumber(item.getIdentificationNumber())
                        .salary(item.getSalary())
                        .email(item.getEmail())
                        .date(item.getDate())
                        .state(item.getStateType())
                        .businessPresenter(BusinessPresenter.builder()
                                .businessName(item.getBusiness().getBusinessName())
                                .build())
                        .departmentPresenter(DepartmentPresenter.builder()
                                .idDepartment(departmentsRepository.findById(item.getIdDepartment()).get().getIdDepartment())
                                .nameDepartment(departmentsRepository.findById(item.getIdDepartment()).get().getNameDepartment())
                                .build())
                        .build()).collect(Collectors.toList());

    }

    @Override
    public void updateEmployee(EmployeesPresenter employeesPresenter) {
        Employees employee = employeesRepository.findById(employeesPresenter.getIdEmployee()).get();
        employee.setFullName(employeesPresenter.getFullName());
        employee.setIdentificationType(employeesPresenter.getIdentificationType());
        employee.setIdentificationNumber(employeesPresenter.getIdentificationNumber());
        employee.setEmail(employeesPresenter.getEmail());
        employee.setSalary(employeesPresenter.getSalary());
        employee.setIdDepartment(employeesPresenter.getDepartmentPresenter().getIdDepartment());
        employee.setDate(employeesPresenter.getDate());
        employeesRepository.save(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        employee.get().setStateType(StateEmployee.INACTIVE);
        employeesRepository.save(employee.get());
    }

    @Override
    public List<EmployeesPresenter> getAllEmployeesWithSupervisor() {
        return employeesRepository.findAllEmployeesWithSupervisor().stream().map(
                item -> EmployeesPresenter.builder()
                        .fullName(item.getFullName())
                        .build()
        ).collect(Collectors.toList());
    }

}
