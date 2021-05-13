package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.model.service.RegisterEmployeesService;
import com.asinfo.test.practice.view.EmployeesPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RegisterEmployeesControllerApi {

    @Autowired
    RegisterEmployeesService registerEmployeesService;

    @GetMapping("/getAllEmployees")
    public List<EmployeesPresenter> getAllEmployees() {
        return registerEmployeesService.getAllEmployees();
    }
}
