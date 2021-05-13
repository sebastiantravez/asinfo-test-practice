package com.asinfo.test.practice.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersRolesPresenter {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id_user;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id_rol;
    private String name;
}
