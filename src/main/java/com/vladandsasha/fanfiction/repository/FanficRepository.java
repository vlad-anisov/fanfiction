package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import org.springframework.data.repository.CrudRepository;

public interface FanficRepository extends CrudRepository<Fanfic, Integer> {

}
