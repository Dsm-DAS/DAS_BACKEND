package com.das.das_backend.domain.feed.service;

import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.feed.domain.repository.FeedRepository;
import com.das.das_backend.domain.feed.exception.FeedCannotDeleteException;
import com.das.das_backend.domain.feed.facade.FeedFacade;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedRepository feedRepository;
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Integer feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedId(feedId);

        if (!user.equals(feed.getUser())) {
            throw FeedCannotDeleteException.EXCEPTION;
        }

        feedRepository.delete(feed);
    }

}
