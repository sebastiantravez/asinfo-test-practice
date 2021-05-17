package com.asinfo.test.practice.service;

import com.asinfo.test.practice.controller.entity.Users;
import com.asinfo.test.practice.controller.entity.UsersRoles;
import com.asinfo.test.practice.controller.repository.UsersRepository;
import com.asinfo.test.practice.controller.repository.UsersRolesRepository;
import com.asinfo.test.practice.view.UsersPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersRolesRepository usersRolesRepository;

    @Override
    public void updateUser(UsersPresenter usersPresenter) {
        Users users = Users.builder()
                .idUser(usersPresenter.getIdUser())
                .userName(usersPresenter.getUserName())
                .password(usersPresenter.getPassword())
                .build();
        usersRepository.save(users);
        usersPresenter.getRolesPresenter().forEach(item -> {
            usersRolesRepository.save(UsersRoles.builder()
                    .idRol(item.getIdRol())
                    .idUser(users.getIdUser())
                    .build());
        });
    }
}
