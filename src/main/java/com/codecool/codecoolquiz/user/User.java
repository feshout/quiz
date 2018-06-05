package com.codecool.codecoolquiz.user;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "person")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Timestamp date;
    private String login;
    private String password;
    private boolean isActive = true;
    @ManyToOne
    private UserAccess userAccess;

    public User() {
    }

    public User(String name, Timestamp date, String login, String password, boolean isActive, UserAccess userAccess) {
        this.name = name;
        this.date = date;
        this.login = login;
        this.password = password;
        this.isActive = isActive;
        this.userAccess = userAccess;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserAccess getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(UserAccess userAccess) {
        this.userAccess = userAccess;
    }
}
