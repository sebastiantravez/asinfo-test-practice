package com.asinfo.test.practice.controller.repository;

import com.asinfo.test.practice.controller.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<Users, UUID> {

    Users findByUserNameAndPassword(@Param("userName") String userName,
                                    @Param("password") String password);

}
