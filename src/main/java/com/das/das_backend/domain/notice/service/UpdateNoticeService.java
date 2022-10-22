package com.das.das_backend.domain.notice.service;

import com.das.das_backend.domain.notice.domain.Notice;
import com.das.das_backend.domain.notice.facade.NoticeFacade;
import com.das.das_backend.domain.notice.presentation.dto.request.UpdateNoticeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateNoticeService {

    private final NoticeFacade noticeFacade;

    @Transactional
    public void execute(UpdateNoticeRequest request, Integer noticeId) {

        Notice notice = noticeFacade.getNoticeById(noticeId);

        notice.updateNotice(request.getTitle(), request.getContent());
    }

}
