package com.das.das_backend.domain.feed.presentation;

import com.das.das_backend.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.das.das_backend.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.das.das_backend.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.das.das_backend.domain.feed.service.CreateFeedService;
import com.das.das_backend.domain.feed.service.DeleteFeedService;
import com.das.das_backend.domain.feed.service.QueryFeedDetailService;
import com.das.das_backend.domain.feed.service.UpdateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;
    private final QueryFeedDetailService queryFeedDetailService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    public void modifyFeed(@PathVariable("feed-id") Integer feedId,
                           @RequestBody @Valid UpdateFeedRequest request) {
        updateFeedService.execute(feedId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @GetMapping("/{feed-id}")
    public FeedDetailResponse getFeedDetail(@PathVariable("feed-id") Integer feedId) {
        return queryFeedDetailService.execute(feedId);
    }

}
