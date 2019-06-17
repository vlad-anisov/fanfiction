package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByActivationCode(String code);
    User findByEmail(String email);
}
