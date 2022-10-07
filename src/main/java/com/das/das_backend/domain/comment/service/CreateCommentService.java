package com.das.das_backend.domain.comment.service;

import com.das.das_backend.domain.comment.domain.Comment;
import com.das.das_backend.domain.comment.domain.repository.CommentRepository;
import com.das.das_backend.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.feed.facade.FeedFacade;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void createComment(Integer feedId, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        Comment comment = Comment.builder()
                .content(request.getContent())
                .user(user)
                .feed(feed)
                .build();

        commentRepository.save(comment);
    }

}
