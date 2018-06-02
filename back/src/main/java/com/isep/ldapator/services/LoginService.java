package com.isep.ldapator.services;

import com.isep.ldapator.entities.User;
import com.isep.ldapator.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;



    public User login(String email, String password) {
        System.out.println("Trying to connect with " + email + " and " + password);

        try {
            String hased = hash(password, "SHA-256");
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return new User(email, password);
    }

    private String hash(String value, String algo) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");


    }
}
