package com.isep.ldapator.services;

import com.isep.ldapator.entities.School;
import com.isep.ldapator.entities.User;
import com.isep.ldapator.entities.UserAddDTO;
import com.isep.ldapator.entities.UserListDTO;
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



    public School addUsers(UserListDTO listDTO) throws Exception {
        School school = schoolRepository.findBySecretHash(listDTO.getToken());
        if (school == null) throw new Exception("Hash is invalid");

        if (school.getUsers() == null) {
            school.setUsers(new ArrayList<>());
        }

        listDTO.getStudents().forEach(dto -> {
            User databasedUser = userRepository.findByEmail(dto.getEmail());
            if (databasedUser == null) {
                System.out.println("Not known in database");
                User user = createEntityFromDto(dto, school);
                userRepository.save(user);
            } else {
                databasedUser.update(dto);
                System.out.println("Known in database");
                userRepository.save(databasedUser);
            }

        });

        return school;
    }

    public User createEntityFromDto(UserAddDTO dto, School school) {
        User user = new User();
        user.setCommonName(dto.getCommonname());
        user.setEmail(dto.getEmail());
        user.setId(dto.getId());
        user.setPassword(dto.getPassword());
        user.setSurName(dto.getSurname());
        user.setSchool(school);

        return user;
    }
}
