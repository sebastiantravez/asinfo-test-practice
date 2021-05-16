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

    @Query(value = "SELECT d.* " +
            " FROM employees e, employees_discriminate d " +
            " WHERE e.id_employee = d.id_employee" +
            " AND d.id_employee = :idEmployee ", nativeQuery = true)
    EmployeesDiscriminate findEmployeeSupervisorByIdEmployee(@Param("idEmployee") UUID idEmployee);
}
