package com.isep.ldapator.controllers;

import com.isep.ldapator.entities.User;
import com.isep.ldapator.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private ResponseEntity<User> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user =  loginService.login(email, password);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

}
