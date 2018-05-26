package com.isep.ldapator.services;

import com.isep.ldapator.entities.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {



    public User login(String email, String password) {
        return new User(email, password);
    }
}
