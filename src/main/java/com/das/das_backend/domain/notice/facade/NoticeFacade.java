package com.das.das_backend.domain.notice.facade;

import com.das.das_backend.domain.notice.domain.Notice;
import com.das.das_backend.domain.notice.domain.repository.NoticeRepository;
import com.das.das_backend.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NoticeFacade {

    private final NoticeRepository noticeRepository;

    public Notice getNoticeById(Integer noticeId) {
        return noticeRepository.findById(noticeId)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);
    }

}
