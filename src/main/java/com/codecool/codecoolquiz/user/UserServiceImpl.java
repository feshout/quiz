package com.codecool.codecoolquiz.user;

import com.codecool.codecoolquiz.annotation.LogAnnotation;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByLogin(String login) {
        return this.userRepository.getByLogin(login);
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        return this.userRepository.getByLoginAndPassword(login, password);
    }

    @LogAnnotation(message = "New user added to database.")
    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }
}
