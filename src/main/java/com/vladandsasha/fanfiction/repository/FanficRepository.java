package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanficRepository extends JpaRepository<Fanfic, Integer> {
    Fanfic findById(int id);
}
