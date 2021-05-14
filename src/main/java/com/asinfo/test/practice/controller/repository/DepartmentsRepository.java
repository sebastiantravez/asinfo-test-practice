package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentsRepository extends CrudRepository<Department, UUID> {

    @Query("FROM Department")
    List<Department> getAllDepartment();
}
