package com.codecool.codecoolquiz.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccessRepository extends CrudRepository<UserAccess, Long> {

    UserAccess getByName(String name);
}
