package com.das.das_backend.domain.feed.domain.repository;

import com.das.das_backend.domain.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed, Integer> {
    
    List<Feed> findAllByOrderByViewsDesc();

}
