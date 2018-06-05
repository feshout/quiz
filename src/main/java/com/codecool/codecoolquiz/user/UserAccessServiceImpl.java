package com.codecool.codecoolquiz.user;

import org.springframework.stereotype.Service;

@Service
public class UserAccessServiceImpl implements UserAccessService {

    private UserAccessRepository userAccessRepository;


    public UserAccessServiceImpl(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    @Override
    public UserAccess getByName(String name) {
        return this.userAccessRepository.getByName(name);
    }
}
