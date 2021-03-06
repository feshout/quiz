package com.codecool.codecoolquiz.user;

import javax.persistence.*;

@Entity
public class UserAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public UserAccess() {
    }

    public UserAccess(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum AccessMode {
        ADMIN, STUDENT
    }
}
