package com.das.das_backend.domain.notice.presentation.dto.response;

import com.das.das_backend.domain.user.presentation.dto.response.WriterResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class QueryNoticeDetailResponse {

    private final Integer noticeId;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Integer views;
    private final WriterResponse writer;

}
