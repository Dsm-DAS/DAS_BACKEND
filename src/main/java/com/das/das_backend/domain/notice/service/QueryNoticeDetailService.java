package com.das.das_backend.domain.notice.service;

import com.das.das_backend.domain.notice.domain.Notice;
import com.das.das_backend.domain.notice.facade.NoticeFacade;
import com.das.das_backend.domain.notice.presentation.dto.response.QueryNoticeDetailResponse;
import com.das.das_backend.domain.user.presentation.dto.response.WriterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryNoticeDetailService {

    private final NoticeFacade noticeFacade;

    @Transactional
    public QueryNoticeDetailResponse execute(Integer noticeId) {

        Notice notice = noticeFacade.getNoticeById(noticeId);
        notice.addViews();

        return QueryNoticeDetailResponse.builder()
                .noticeId(noticeId)
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .updatedAt(notice.getUpdatedAt())
                .views(notice.getViews())
                .writer(WriterResponse.builder()
                        .userId(notice.getUser().getId())
                        .name(notice.getUser().getName())
                        .profileImageUrl(notice.getUser().getProfileImageUrl())
                        .build())
                .build();
    }

}
