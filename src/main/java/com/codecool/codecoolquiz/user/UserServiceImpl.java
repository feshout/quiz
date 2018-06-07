package com.codecool.codecoolquiz.user;

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

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }
}
