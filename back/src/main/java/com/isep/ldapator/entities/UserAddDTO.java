package com.isep.ldapator.entities;

import java.util.List;

public class UserAddDTO {


    private String schoolHash;

    private List<User> users;

    public String getSchoolHash() {
        return schoolHash;
    }

    public void setSchoolHash(String schoolHash) {
        this.schoolHash = schoolHash;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserAddDTO{" +
                "schoolHash='" + schoolHash + '\'' +
                ", users=" + users +
                '}';
    }
}
