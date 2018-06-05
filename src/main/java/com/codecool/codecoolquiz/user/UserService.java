package com.codecool.codecoolquiz.user;

public interface UserService {

    User getByLogin(String login);

    User getByLoginAndPassword(String login, String password);

    void save(User user);

}
