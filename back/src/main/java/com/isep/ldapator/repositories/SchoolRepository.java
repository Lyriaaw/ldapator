package com.isep.ldapator.repositories;

import com.isep.ldapator.entities.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    School findBySecretHash(String secretHash);
}
