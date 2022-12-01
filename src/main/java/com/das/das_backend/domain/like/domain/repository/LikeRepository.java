package com.das.das_backend.domain.like.domain.repository;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.like.domain.Like;
import com.das.das_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Integer> {

    boolean existsByUserAndClub(User user, Club club);

    void deleteByUserAndClub(User user, Club club);

}
