package com.vladandsasha.fanfiction.repository;

import com.vladandsasha.fanfiction.fanfics.Chapter;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepository extends CrudRepository<Chapter,Integer> {
    Chapter findById(int id);
}
