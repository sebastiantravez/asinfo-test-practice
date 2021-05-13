package com.asinfo.test.practice.view;

import com.asinfo.test.practice.controller.entity.Employees;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "idUser")
@ToString(of = "idUser")
@NoArgsConstructor
@AllArgsConstructor
public class UsersPresenter {

    private UUID idUser;

    private String user;

    private String password;

    private String token;

}
