package com.asinfo.test.practice.model.service.implement;

import com.asinfo.test.practice.controller.repository.EmployeesRepository;
import com.asinfo.test.practice.model.service.EmployeesService;
import com.asinfo.test.practice.view.EmployeesPresenter;
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
    public List<EmployeesPresenter> getAllEmployees() {
        return employeesRepository.findByAllEmployees().stream()
                .filter(Objects::nonNull)
                .map(item -> EmployeesPresenter.builder()
                        .id(item.getId())
                        .fullName(item.getFullName())
                        .build()).collect(Collectors.toList());

    }

    @Override
    public void saveEmployees() {

    }
}
