package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.fanfics.Chapter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter,Integer> {
    Chapter findById(int id);
}
