package com.das.das_backend.domain.notice.presentation;


import com.das.das_backend.domain.notice.presentation.dto.request.CreateNoticeRequest;
import com.das.das_backend.domain.notice.presentation.dto.request.UpdateNoticeRequest;
import com.das.das_backend.domain.notice.presentation.dto.response.QueryNoticeDetailResponse;
import com.das.das_backend.domain.notice.service.CreateNoticeService;
import com.das.das_backend.domain.notice.service.DeleteNoticeService;
import com.das.das_backend.domain.notice.service.QueryNoticeDetailService;
import com.das.das_backend.domain.notice.service.UpdateNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/notice")
@RestController
public class NoticeController {

    private final CreateNoticeService createNoticeService;
    private final UpdateNoticeService updateNoticeService;
    private final DeleteNoticeService deleteNoticeService;
    private final QueryNoticeDetailService queryNoticeDetailService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNotice(@RequestBody @Valid CreateNoticeRequest request) {
        createNoticeService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{notice-id}")
    public void updateNotice(@RequestBody @Valid UpdateNoticeRequest request,
                             @PathVariable(name = "notice-id") Integer noticeId) {
        updateNoticeService.execute(request, noticeId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{notice-id}")
    public void deleteNotice(@PathVariable(name = "notice-id") Integer noticeId) {
        deleteNoticeService.execute(noticeId);
    }

    @GetMapping("/{notice-id}")
    public QueryNoticeDetailResponse getNoticeDetail(@PathVariable(name = "notice-id") Integer noticeId) {
        return queryNoticeDetailService.execute(noticeId);
    }

}
