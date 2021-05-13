package com.asinfo.test.practice.model.service;

import com.asinfo.test.practice.view.EmployeesPresenter;

import java.util.List;

public interface EmployeesService {

    void saveEmployees(EmployeesPresenter employeesPresenter);

    List<EmployeesPresenter> getAllEmployees();

}
