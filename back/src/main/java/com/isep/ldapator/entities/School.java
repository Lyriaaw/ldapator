package com.isep.ldapator.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class School {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String secretHash;


}
