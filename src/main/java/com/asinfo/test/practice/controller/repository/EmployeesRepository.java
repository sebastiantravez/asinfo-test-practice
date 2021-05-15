package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Employees;
import com.asinfo.test.practice.controller.enums.IdentificationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, UUID> {

    @Query("FROM Employees")
    List<Employees> findByAllEmployees();

    Employees findByIdentificationTypeAndIdentificationNumber(@Param("identificationType") IdentificationType identificationType,
                                                              @Param("identificationNumber") String identificationNumber);

    @Query("FROM Employees e WHERE e.users.idUser =: idUser")
    Employees findByIdUser(@Param("idUser") UUID idUser);
}
