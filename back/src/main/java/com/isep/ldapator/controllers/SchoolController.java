package com.isep.ldapator.controllers;

import com.isep.ldapator.entities.School;
import com.isep.ldapator.entities.UserAddDTO;
import com.isep.ldapator.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity addUsers(@RequestBody UserAddDTO dto) {
        System.out.println(dto.toString());
        try {
            School school = schoolService.addUsers(dto);
            return new ResponseEntity<>(school, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
