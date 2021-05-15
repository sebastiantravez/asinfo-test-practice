package com.asinfo.test.practice.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRolesRepository extends CrudRepository<com.asinfo.test.practice.controller.entity.UsersRoles, UUID> {
}
