package com.asinfo.test.practice.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersPresenter {

    private UUID idUser;
    private String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
    private List<UsersRolesPresenter> usersRolesPresenters;

}
