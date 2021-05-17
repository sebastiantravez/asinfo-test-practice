package com.asinfo.test.practice.controller.security.repository;


import com.asinfo.test.practice.controller.enums.EnumRol;
import com.asinfo.test.practice.controller.security.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RolRepository extends JpaRepository<Rol, UUID> {

    Optional<Rol> findByName(EnumRol rolName);
}
