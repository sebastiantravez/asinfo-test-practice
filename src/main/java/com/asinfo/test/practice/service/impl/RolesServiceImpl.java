package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.repository.RolesRepository;
import com.asinfo.test.practice.service.RolesService;
import com.asinfo.test.practice.view.RolesPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public List<RolesPresenter> getAllRoles() {
        return rolesRepository.getAllRoles().stream().map(
                item -> RolesPresenter.builder()
                        .idRol(item.getIdRol())
                        .name(item.getName())
                        .build()
        ).collect(Collectors.toList());
    }
}
