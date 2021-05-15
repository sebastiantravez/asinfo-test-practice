package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BusinessRepository extends CrudRepository<Business, UUID> {
}
