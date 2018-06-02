package com.isep.ldapator.controllers;

import com.isep.ldapator.entities.School;
import com.isep.ldapator.entities.UserAddDTO;
import com.isep.ldapator.entities.UserListDTO;
import com.isep.ldapator.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "schools/")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value="add", method = RequestMethod.POST)
    public ResponseEntity addSchool(@RequestBody School school) {
        school = schoolService.saveSchool(school);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }


    @RequestMapping(value="users", method = RequestMethod.POST)
    public ResponseEntity addUsers(@RequestBody UserListDTO listDTO) {
        System.out.println(listDTO.toString());
        try {
            School school = schoolService.addUsers(listDTO);
            return new ResponseEntity<>(school, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.FORBIDDEN);
        }
    }





}
