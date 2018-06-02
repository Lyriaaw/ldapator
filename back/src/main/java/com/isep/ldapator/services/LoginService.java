package com.isep.ldapator.services;

import com.google.common.hash.Hashing;
import com.isep.ldapator.entities.User;
import com.isep.ldapator.repositories.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;



    public User login(String email, String password) throws LoginException {
        System.out.println("Trying to connect with " + email + " and " + password);
        String hashed = generateHashedPassword(password);

        User user = userRepository.findByEmailAndPassword(email, hashed);
        if (user == null) throw new LoginException();

        return user;
    }

    public String generateHashedPassword(String password) {
        StringBuilder builder = new StringBuilder("{SHA}");
        builder.append(new String(Base64.encodeBase64(DigestUtils.sha1(password.getBytes()))));
        return builder.toString();
    }


}
