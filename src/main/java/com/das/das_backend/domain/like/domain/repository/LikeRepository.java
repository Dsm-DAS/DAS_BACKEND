package com.das.das_backend.domain.like.domain.repository;

import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.like.domain.Like;
import com.das.das_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Integer> {

    boolean existsByUserAndFeed(User user, Feed feed);

    void deleteByUserAndFeed(User user, Feed feed);

}
