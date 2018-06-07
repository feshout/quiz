package com.codecool.codecoolquiz.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User getByLoginAndPassword(String login, String password);

    User getByLogin(String login);

    User findDistinctByLogin(String login);
}
