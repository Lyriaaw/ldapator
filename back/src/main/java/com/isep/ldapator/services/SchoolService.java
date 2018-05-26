package com.isep.ldapator.services;

import com.isep.ldapator.entities.School;
import com.isep.ldapator.entities.User;
import com.isep.ldapator.entities.UserAddDTO;
import com.isep.ldapator.repositories.SchoolRepository;
import com.isep.ldapator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private UserRepository userRepository;



    public School saveSchool(School school) {
        school.setSecretHash(UUID.randomUUID().toString());
        school = schoolRepository.save(school);
        return school;
    }



    public School addUsers(UserAddDTO dto) throws Exception {
        School school = schoolRepository.findBySecretHash(dto.getSchoolHash());
        if (school == null) throw new Exception("Hash is invalid");

        if (school.getUsers() == null) {
            school.setUsers(new ArrayList<>());
        }

        dto.getUsers().forEach(user -> {
            User databasedUser = userRepository.findByEmail(user.getEmail());
            if (databasedUser == null) {
                user.setSchool(school);
                userRepository.save(user);
            } else {
                databasedUser.update(user);
                userRepository.save(databasedUser);
            }
        });



        return school;
    }
}
