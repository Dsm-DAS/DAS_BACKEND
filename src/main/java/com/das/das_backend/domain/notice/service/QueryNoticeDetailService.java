package com.das.das_backend.domain.notice.service;

import com.das.das_backend.domain.notice.domain.Notice;
import com.das.das_backend.domain.notice.facade.NoticeFacade;
import com.das.das_backend.domain.notice.presentation.dto.response.QueryNoticeDetailResponse;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryNoticeDetailService {

    private final NoticeFacade noticeFacade;
    private final UserFacade userFacade;

    @Transactional
    public QueryNoticeDetailResponse execute(Integer noticeId) {

        Notice notice = noticeFacade.getNoticeById(noticeId);
        User writer = notice.getUser();

        notice.addViews();

        return QueryNoticeDetailResponse.builder()
                .noticeId(noticeId)
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .updatedAt(notice.getUpdatedAt())
                .views(notice.getViews())
                .writer(userFacade.getWriter(writer))
                .build();
    }

}
