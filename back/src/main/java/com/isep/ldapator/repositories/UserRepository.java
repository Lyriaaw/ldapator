package com.isep.ldapator.repositories;

import com.isep.ldapator.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

}
