package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
