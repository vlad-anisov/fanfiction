package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FanficRepository extends JpaRepository<Fanfic, Integer> {
    //List<Fanfic> findByTag(String tag);
    Fanfic findById(int id);

    //@Query(value = "SELECT title from fanfic where user_id=?1", nativeQuery=true)
    //List<String> findByUser(int user);
}
