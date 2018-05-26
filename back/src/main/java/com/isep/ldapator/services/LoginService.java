package com.isep.ldapator.services;

import com.isep.ldapator.entities.User;
import com.isep.ldapator.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;



    public User login(String email, String password) {


        return new User(email, password);
    }
}
