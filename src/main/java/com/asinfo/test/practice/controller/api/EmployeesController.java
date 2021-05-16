package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.EmployeesService;
import com.asinfo.test.practice.view.EmployeesPresenter;
import com.asinfo.test.practice.view.MessagePresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@CrossOrigin
public class EmployeesController {

    @Autowired
    EmployeesService employeesService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeesPresenter employeesPresenter, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new MessagePresenter("Datos inválidos"), HttpStatus.BAD_REQUEST);
        employeesService.saveEmployees(employeesPresenter);
        return new ResponseEntity(new MessagePresenter("Registro creado"), HttpStatus.CREATED);
    }

    @GetMapping("/getAllEmployees")
    @ResponseBody
    public List<EmployeesPresenter> getAllEmployees(@RequestParam("id") UUID id) {
        return employeesService.getAllEmployees(id);
    }

    @PostMapping("/updateEmployee")
    public void updateEmployee(@RequestBody EmployeesPresenter employeesPresenter) {
        employeesService.updateEmployee(employeesPresenter);
    }

    @GetMapping("/deleteEmployee")
    @ResponseBody
    public void deleteEmployee(@RequestParam("id") UUID id) {
        employeesService.deleteEmployee(id);
    }

    @GetMapping("/searchEmployees/{searchValue}")
    public List<EmployeesPresenter> searchEmployees(@PathVariable("searchValue") String searchValue) {
        return employeesService.searchEmployees(searchValue);
    }

    @GetMapping("/getAllEmployeesSupervisor")
    public List<EmployeesPresenter> getAllEmployees() {
        return employeesService.getAllEmployeesSupervisor();
    }
}
