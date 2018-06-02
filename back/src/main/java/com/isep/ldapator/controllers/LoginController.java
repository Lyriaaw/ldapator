package com.isep.ldapator.controllers;

import com.isep.ldapator.entities.LoginDTO;
import com.isep.ldapator.entities.User;
import com.isep.ldapator.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private ResponseEntity<User> login(@RequestBody LoginDTO login) {
        User user =  loginService.login(login.getEmail(), login.getPassword());
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private ResponseEntity<User> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user =  loginService.login(password, password);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }



}
