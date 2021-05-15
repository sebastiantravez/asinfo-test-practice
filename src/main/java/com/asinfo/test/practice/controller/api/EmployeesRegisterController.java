package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.EmployeesService;
import com.asinfo.test.practice.view.EmployeesPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeesRegisterController {

    @Autowired
    EmployeesService employeesService;

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody EmployeesPresenter employeesPresenter) {
        employeesService.saveEmployees(employeesPresenter);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeesPresenter> getAllEmployees() {
        return employeesService.getAllEmployees();
    }
}
