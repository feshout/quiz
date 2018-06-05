package com.codecool.codecoolquiz.security;

import com.codecool.codecoolquiz.user.User;
import com.codecool.codecoolquiz.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        User user = userRepository.findDistinctByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user named " + username);
        } else {
            return new UserDetailsImpl(user);
        }
    }
}