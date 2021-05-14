package com.asinfo.test.practice.service;

import com.asinfo.test.practice.view.UsersPresenter;

public interface AuthenticationService {
    UsersPresenter authentication(String user, String password);
}
