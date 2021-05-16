package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.GenerateReportService;
import com.asinfo.test.practice.view.EmployeesPresenter;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
public class GenerateReportController {

    @Autowired
    GenerateReportService generateReportService;

    @GetMapping("/generateReport")
    public EmployeesPresenter generateReport() throws IOException, JRException {
        return generateReportService.generateEmployeesReport();
    }
}
