package com.asinfo.test.practice.service;

import com.asinfo.test.practice.view.EmployeesPresenter;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public interface GenerateReportService {
    EmployeesPresenter generateEmployeesReport() throws IOException, JRException;
}
