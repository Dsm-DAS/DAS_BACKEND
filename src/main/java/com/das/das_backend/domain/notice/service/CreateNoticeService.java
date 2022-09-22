package com.das.das_backend.domain.notice.service;


import com.das.das_backend.domain.notice.domain.Notice;
import com.das.das_backend.domain.notice.domain.repository.NoticeRepository;
import com.das.das_backend.domain.notice.presentation.dto.request.CreateNoticeRequest;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CreateNoticeService {

    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateNoticeRequest request) {
        User user = userFacade.getCurrentUser();

        noticeRepository.save(Notice.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .views(0)
                .user(user)
                .build());
    }

}
