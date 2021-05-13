package com.asinfo.test.practice.model.service;

import com.asinfo.test.practice.view.EmployeesPresenter;

import java.util.List;

public interface RegisterEmployeesService {
    void saveEmployees();
    List<EmployeesPresenter> getAllEmployees();

}
