package com.asinfo.test.practice.controller.security.service;


import com.asinfo.test.practice.controller.enums.EnumRol;
import com.asinfo.test.practice.controller.security.entity.Rol;
import com.asinfo.test.practice.controller.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(EnumRol rol){
    return rolRepository.findByName(rol);
    }
}
