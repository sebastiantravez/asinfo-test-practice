package com.asinfo.test.practice.service;

import com.asinfo.test.practice.view.EmployeesPresenter;

import java.util.List;
import java.util.UUID;

public interface EmployeesService {

    EmployeesPresenter saveEmployees(EmployeesPresenter employeesPresenter);

    List<EmployeesPresenter> getAllEmployees(UUID idSupervisor);

    void updateEmployee(EmployeesPresenter employeesPresenter);

    void deleteEmployee(UUID id);

    List<EmployeesPresenter> getAllEmployeesWithSupervisorReport();

    List<EmployeesPresenter> searchEmployees(String searchValue);

    List<EmployeesPresenter> getAllEmployeesSupervisor();
}
