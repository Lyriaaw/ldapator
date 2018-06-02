package com.isep.ldapator.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;

    private String commonName;

    private String surName;

    @ManyToOne
    private School school;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @JsonIgnore
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", commonName='" + commonName + '\'' +
                ", surName='" + surName + '\'' +
                ", school=" + school +
                '}';
    }

    // If the two password are not the same, we need to update
    // TODO : Add other elements
    public boolean needUpdate(User user) {
        return !Objects.equals(user.password, this.password);
    }

    public User update(UserAddDTO user) {
        if (!this.getPassword().equals(user.getPassword())) this.password = user.getPassword();
        if (!this.getCommonName().equals(user.getCommonname())) this.commonName = user.getCommonname();
        if (!this.getSurName().equals(user.getSurname())) this.surName = user.getSurname();
        return this;
    }



}
