package com.asinfo.test.practice.view;

import com.asinfo.test.practice.controller.entity.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersPresenter {

    private String user;

    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    private List<UsersRolesPresenter> usersRolesPresenters;

}
