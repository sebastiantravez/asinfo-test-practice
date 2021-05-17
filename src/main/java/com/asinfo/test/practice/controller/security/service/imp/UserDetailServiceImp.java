package com.asinfo.test.practice.controller.security.service.imp;

import com.asinfo.test.practice.controller.security.entity.PrimaryUser;
import com.asinfo.test.practice.controller.security.entity.User;
import com.asinfo.test.practice.controller.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByNick(username).get();
        return PrimaryUser.build(user);
    }
}
