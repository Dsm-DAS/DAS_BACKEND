package com.das.das_backend.domain.notice.service;

import com.das.das_backend.domain.notice.domain.Notice;
import com.das.das_backend.domain.notice.domain.repository.NoticeRepository;
import com.das.das_backend.domain.notice.facade.NoticeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteNoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeFacade noticeFacade;

    @Transactional
    public void execute(Integer noticeId) {

        Notice notice = noticeFacade.getNoticeById(noticeId);

        noticeRepository.delete(notice);
    }
}
