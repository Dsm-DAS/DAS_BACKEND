package com.das.das_backend.domain.feed.service;

import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.feed.exception.FeedCannotUpdateException;
import com.das.das_backend.domain.feed.facade.FeedFacade;
import com.das.das_backend.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Integer feedId, UpdateFeedRequest request) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedId(feedId);

        if (!user.equals(feed.getUser())) {
            throw FeedCannotUpdateException.EXCEPTION;
        }

        feed.modifyFeed(request.getTitle(),
                request.getContent(), request.getDasUrl());
    }

}
