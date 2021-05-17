package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.util.Util;
import com.asinfo.test.practice.service.EmployeesService;
import com.asinfo.test.practice.service.GenerateReportService;
import com.asinfo.test.practice.service.JasperReportService;
import com.asinfo.test.practice.view.EmployeesPresenter;
import liquibase.pro.packaged.U;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenerateReportServiceImpl implements GenerateReportService {

    @Autowired
    JasperReportService jasperReportService;
    @Autowired
    EmployeesService employeesService;

    private final Util util = new Util();

    @Override
    public EmployeesPresenter generateEmployeesReport() throws IOException, JRException {
        List<EmployeesPresenter> employeesPresenters = employeesService.getAllEmployeesWithSupervisorReport();
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("business", "ASINFO S.A");
        return EmployeesPresenter.builder()
                .pdf(jasperReportService.getReportWithCollectionDataSource(
                        "employeeReport", parameters, this.getEmployeesLines(employeesPresenters)))
                .build();
    }

    private List<HashMap<Object, Object>> getEmployeesLines(List<EmployeesPresenter> employeesPresenters) {
        return employeesPresenters.stream().map(employeesPresenter -> {
            HashMap<Object, Object> line = new HashMap<>();
            line.put("fullName", employeesPresenter.getFullName());
            line.put("identificationNumber", employeesPresenter.getIdentificationNumber());
            line.put("salary", "$ " + util.decimal(employeesPresenter.getSalary()));
            line.put("email", employeesPresenter.getEmail());
            line.put("date", employeesPresenter.getDate().toString());
            line.put("department", employeesPresenter.getDepartmentPresenter().getNameDepartment());
            line.put("supervisor", employeesPresenter.getNameSupervisor());
            return line;
        }).collect(Collectors.toList());

    }
}
