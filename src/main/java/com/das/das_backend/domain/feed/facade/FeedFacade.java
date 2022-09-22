package com.das.das_backend.domain.feed.facade;

import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedId(Integer feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> )
    }
}


