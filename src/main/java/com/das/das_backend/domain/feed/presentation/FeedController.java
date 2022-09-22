package com.das.das_backend.domain.feed.presentation;

import com.das.das_backend.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.das.das_backend.domain.feed.service.CreateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }

}
