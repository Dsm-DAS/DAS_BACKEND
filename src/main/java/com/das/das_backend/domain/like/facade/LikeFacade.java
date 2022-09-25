package com.das.das_backend.domain.like.facade;

import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.like.domain.repository.LikeRepository;
import com.das.das_backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {

    private final LikeRepository likeRepository;

    public boolean checkLiked(User user, Feed feed) {
        return likeRepository.existsByUserAndFeed(user, feed);
    }

}
