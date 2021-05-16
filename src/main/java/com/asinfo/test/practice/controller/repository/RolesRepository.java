package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RolesRepository extends CrudRepository<Roles, UUID> {

    @Query("FROM Roles")
    Set<Roles> getAllRoles();
}
