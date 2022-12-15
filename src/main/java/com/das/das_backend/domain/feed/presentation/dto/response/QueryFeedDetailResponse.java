package com.das.das_backend.domain.feed.presentation.dto.response;

import com.das.das_backend.domain.user.presentation.dto.response.WriterResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class QueryFeedDetailResponse {

    private final Integer feedId;
    private final String title;
    private final String content;
    private final String dasUrl;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Integer views;
    private final boolean isMine;
    private final WriterResponse writer;
    private final List<CommentResponse> commentList;

    @Getter
    @Builder
    public static class CommentResponse {
        private final Integer commentId;
        private final String content;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;
        private final WriterResponse writer;
    }

}
