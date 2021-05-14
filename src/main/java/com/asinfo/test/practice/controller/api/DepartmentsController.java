package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.DepartmentsService;
import com.asinfo.test.practice.view.DepartmentPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DepartmentsController {

    @Autowired
    DepartmentsService departmentsService;

    @GetMapping("/getAllDepartments")
    public List<DepartmentPresenter> getAllDepartments() {
        return departmentsService.getDepartments();
    }
}
