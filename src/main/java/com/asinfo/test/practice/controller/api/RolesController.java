package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.RolesService;
import com.asinfo.test.practice.view.RolesPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RolesController {

    @Autowired
    RolesService rolesService;

    @GetMapping("/getAllRoles")
    public List<RolesPresenter> getAllRoles() {
        return rolesService.getAllRoles();
    }
}
