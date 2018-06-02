package com.isep.ldapator.controllers;

import com.isep.ldapator.entities.LoginDTO;
import com.isep.ldapator.entities.User;
import com.isep.ldapator.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private ResponseEntity login(@RequestBody LoginDTO login) {
        User user = null;
        try {
            user = loginService.login(login.getEmail(), login.getPassword());
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (LoginException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private ResponseEntity login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = null;
        try {
            user = loginService.login(email, password);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (LoginException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }



}
