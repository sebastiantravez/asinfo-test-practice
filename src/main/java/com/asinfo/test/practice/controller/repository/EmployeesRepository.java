package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Employees;
import com.asinfo.test.practice.controller.enums.IdentificationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, UUID> {

    @Query(value = "SELECT * " +
            " FROM employees e, employees_discriminate d, charges c" +
            " WHERE e.id_employee = d.id_employee" +
            " AND e.id_charge = c.id_charge" +
            " AND e.state = 'ACTIVE'" +
            " AND d.id_supervisor = :idSupervisor" +
            " ORDER BY e.date desc", nativeQuery = true)
    List<Employees> findEmployeesBySupervisor(@Param("idSupervisor") UUID idSupervisor);

    Employees findByIdentificationTypeAndIdentificationNumber(@Param("identificationType") IdentificationType identificationType,
                                                                        @Param("identificationNumber") String identificationNumber);

    @Query("SELECT e" +
            " FROM Employees as e " +
            " WHERE e.idUser = :id ")
    Employees findDataUsersByIdUser(@Param("id") UUID id);

    Employees findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM employees", nativeQuery = true)
    List<Employees> findAllEmployeesWithSupervisor();

    @Query(value = "SELECT *," +
            " (SELECT s.full_name FROM employees s WHERE s.id_employee = t.id_supervisor) as nameSupervisor," +
            " (SELECT a.name FROM employees s, charges a WHERE s.id_employee = t.id_supervisor and s.id_charge = a.id_charge) as cargo" +
            " FROM employees e, employees_discriminate t, charges c" +
            " WHERE e.id_employee = t.id_employee" +
            " AND e.id_charge = c.id_charge" +
            " ORDER BY e.date DESC", nativeQuery = true)
    List<Employees> findEmployeesWithSupervisor();

    @Query("SELECT e" +
            " FROM Employees e" +
            " WHERE LOWER(e.fullName) LIKE LOWER(CONCAT('%',:searchValue,'%'))" +
            " OR e.identificationNumber LIKE LOWER(CONCAT('%',:searchValue,'%'))" +
            " OR LOWER(e.email) LIKE LOWER(CONCAT('%',:searchValue,'%'))")
    List<Employees> searchEmployees(@Param("searchValue") String searchValue);

    @Query(value = "SELECT * " +
            " FROM  employees e, employees_discriminate d " +
            " WHERE e.id_employee = d.id_supervisor", nativeQuery = true)
    Set<Employees> findEmployeesSupervisor();
}
