package com.asinfo.test.practice.controller.security.repository;

import com.asinfo.test.practice.controller.security.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByNick(String userNick);

    Boolean existsByNick(String userNick);

    Boolean existsByEmail(String userEmail);
}
