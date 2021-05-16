package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Employees;
import com.asinfo.test.practice.controller.entity.EmployeesDiscriminate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeDiscriminateRepository extends CrudRepository<EmployeesDiscriminate, UUID> {


    @Query(value = "SELECT d " +
            " FROM EmployeesDiscriminate d" +
            " JOIN d.employees e" +
            " WHERE d.idEmployee = e.idEmployee" +
            " AND d.idEmployee = :idEmployee")
    EmployeesDiscriminate findEmployeeSupervisorByIdEmployee(@Param("idEmployee") UUID idEmployee);
}
