package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Employees;
import com.asinfo.test.practice.controller.enums.IdentificationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, UUID> {

    @Query(value = "SELECT * " +
            " FROM employees e, employees_discriminate d, charges c" +
            " WHERE e.id_employee = d.id_employee" +
            " AND e.id_charge = c.id_charge" +
            " AND e.state = 'ACTIVE'" +
            " AND d.id_supervisor = :idSupervisor", nativeQuery = true)
    List<Employees> findEmployeesBySupervisor(@Param("idSupervisor") UUID idSupervisor);

    Optional<Employees> findByIdentificationTypeAndIdentificationNumber(@Param("identificationType") IdentificationType identificationType,
                                                                        @Param("identificationNumber") String identificationNumber);

    @Query("SELECT e" +
            " FROM Employees as e " +
            " WHERE e.idUser = :id ")
    Employees findDataUsersByIdUser(@Param("id") UUID id);

    Optional<Employees> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM employees", nativeQuery = true)
    List<Employees> findAllEmployeesWithSupervisor();
}
