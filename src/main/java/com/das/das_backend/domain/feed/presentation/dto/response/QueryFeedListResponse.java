package com.das.das_backend.domain.feed.presentation.dto.response;

import com.das.das_backend.domain.user.presentation.dto.response.WriterResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class QueryFeedListResponse {

    private final List<FeedResponse> feedList;

    @Getter
    @Builder
    public static class FeedResponse {
        private final WriterResponse writer;
        private final Integer feedId;
        private final String title;
        private final LocalDateTime createdAt;
        private final Integer views;
    }

}
