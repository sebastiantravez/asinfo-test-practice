package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.UserService;
import com.asinfo.test.practice.view.UsersPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody UsersPresenter usersPresenter) {
        userService.updateUser(usersPresenter);
    }

}
