package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FanficRepository extends CrudRepository<Fanfic, Integer> {
    List<Fanfic> findByTag(String tag);
}
