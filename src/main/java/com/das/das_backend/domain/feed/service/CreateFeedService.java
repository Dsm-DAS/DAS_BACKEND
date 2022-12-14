package com.das.das_backend.domain.feed.service;

import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.feed.domain.repository.FeedRepository;
import com.das.das_backend.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateFeedRequest request) {
        User user = userFacade.getCurrentUser();

        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .dasUrl(request.getDasUrl())
                .major(request.getMajor())
                .endAt(request.getEndAt())
                .views(0)
                .user(user)
                .build());
    }

}
