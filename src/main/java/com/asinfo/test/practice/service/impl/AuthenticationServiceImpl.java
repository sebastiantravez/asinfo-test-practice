package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.entity.Users;
import com.asinfo.test.practice.controller.repository.UsersRepository;
import com.asinfo.test.practice.service.AuthenticationService;
import com.asinfo.test.practice.view.UsersPresenter;
import com.asinfo.test.practice.view.UsersRolesPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UsersPresenter authentication(String user, String password) {
        Users users = usersRepository.findByUserAndPassword(user, password);
        if (users != null) {
            return UsersPresenter.builder()
                    .idUser(users.getIdUser())
                    .user(users.getUser())
                    .usersRolesPresenters(users.getRoles().stream().map(
                            item -> UsersRolesPresenter.builder()
                                    .name(item.getName())
                                    .build()
                    ).collect(Collectors.toList()))
                    .build();

        }
        return null;
    }
}
