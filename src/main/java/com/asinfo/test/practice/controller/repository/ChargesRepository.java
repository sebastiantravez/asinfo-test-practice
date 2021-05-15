package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Charges;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface ChargesRepository extends CrudRepository<Charges, UUID> {

    @Query("FROM Charges")
    List<Charges> getAllCharges();

    Charges findByName(@Param("name") String name);
}
