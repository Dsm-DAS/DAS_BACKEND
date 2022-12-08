package com.das.das_backend.domain.notice.service;

import com.das.das_backend.domain.notice.domain.repository.NoticeRepository;
import com.das.das_backend.domain.notice.presentation.dto.response.QueryNoticeListResponse;
import com.das.das_backend.domain.notice.presentation.dto.response.QueryNoticeListResponse.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryNoticeListService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public QueryNoticeListResponse execute() {

        List<NoticeResponse> noticeResponseList = noticeRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(notice -> NoticeResponse
                        .builder()
                        .noticeId(notice.getId())
                        .title(notice.getTitle())
                        .createdAt(notice.getCreatedAt())
                        .viewCounts(notice.getViews())
                        .build())
                .collect(Collectors.toList());

        return new QueryNoticeListResponse(noticeResponseList);
    }

}
