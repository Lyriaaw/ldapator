package com.isep.ldapator.entities;

import java.util.ArrayList;
import java.util.List;

public class UserListDTO {


    private String token;

    private List<UserAddDTO> students = new ArrayList<>();


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<UserAddDTO> getStudents() {
        return students;
    }

    public void setStudents(List<UserAddDTO> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "UserListDTO{" +
                "token='" + token + '\'' +
                ", students=" + students +
                '}';
    }
}
