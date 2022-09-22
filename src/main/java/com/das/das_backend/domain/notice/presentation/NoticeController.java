package com.das.das_backend.domain.notice.presentation;


import com.das.das_backend.domain.notice.presentation.dto.request.CreateNoticeRequest;
import com.das.das_backend.domain.notice.service.CreateNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/notice")
@RestController
public class NoticeController {

    private final CreateNoticeService createNoticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNotice(@RequestBody @Valid CreateNoticeRequest request) {
        createNoticeService.execute(request);
    }


}
