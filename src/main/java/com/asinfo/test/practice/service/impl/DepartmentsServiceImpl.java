package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.repository.DepartmentsRepository;
import com.asinfo.test.practice.service.DepartmentsService;
import com.asinfo.test.practice.view.DepartmentPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    DepartmentsRepository departmentsRepository;

    @Override
    public List<DepartmentPresenter> getDepartments() {
        return departmentsRepository.getAllDepartment().stream().map(
                item -> DepartmentPresenter.builder()
                        .idDepartment(item.getIdDepartment())
                        .nameDepartment(item.getNameDepartment())
                        .build()
        ).collect(Collectors.toList());
    }
}
