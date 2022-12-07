package com.das.das_backend.domain.notice.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class QueryNoticeListResponse {

    private final List<NoticeResponse> noticeResponseList;

    @Getter
    @Builder
    public static class NoticeResponse {
        private final Integer noticeId;
        private final String title;
        private final LocalDateTime createdAt;
        private final Integer viewCounts;
    }

}
