package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.AuthenticationService;
import com.asinfo.test.practice.view.UsersPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public UsersPresenter authenticationUser(@RequestBody @NotNull UsersPresenter usersPresenter) {
        String user = usersPresenter.getUser();
        String password = usersPresenter.getPassword();
        return authenticationService.authentication(user, password);
    }
}
