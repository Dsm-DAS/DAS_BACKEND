package com.das.das_backend.domain.comment.facade;

import com.das.das_backend.domain.comment.domain.Comment;
import com.das.das_backend.domain.comment.domain.repository.CommentRepository;
import com.das.das_backend.domain.comment.exception.CommentNotFoundException;
import com.das.das_backend.domain.feed.domain.Feed;
import com.das.das_backend.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.das.das_backend.domain.feed.presentation.dto.response.FeedDetailResponse.CommentResponse;
import com.das.das_backend.domain.feed.presentation.dto.response.FeedDetailResponse.Writer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getComment(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

    public List<CommentResponse> getComments(Feed feed) {

        return feed.getCommentList()
                .stream().map(comment -> FeedDetailResponse.CommentResponse.builder()
                        .commentId(comment.getId())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .updatedAt(comment.getUpdatedAt())
                        .writer(Writer.builder()
                                .userId(comment.getUser().getId())
                                .name(comment.getUser().getName())
                                .profileImageUrl(comment.getUser().getProfileImageUrl())
                                .build())
                        .build())
                .collect(Collectors.toList());
    }

}