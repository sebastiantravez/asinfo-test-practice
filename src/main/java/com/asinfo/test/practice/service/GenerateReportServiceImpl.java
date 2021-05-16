package com.asinfo.test.practice.service;

import com.asinfo.test.practice.view.EmployeesPresenter;
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

    @Override
    public EmployeesPresenter generateEmployeesReport() throws IOException, JRException {
        List<EmployeesPresenter> employeesPresenters = employeesService.getAllEmployeesWithSupervisor();
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
            return line;
        }).collect(Collectors.toList());

    }
}
