package com.das.das_backend.domain.feed.presentation;

import com.das.das_backend.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.das.das_backend.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.das.das_backend.domain.feed.presentation.dto.response.QueryFeedDetailResponse;
import com.das.das_backend.domain.feed.presentation.dto.response.QueryFeedListResponse;
import com.das.das_backend.domain.feed.service.*;
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
    private final QueryFeedListViewsService queryFeedListViewsService;
    private final QueryFeedListService queryFeedListService;

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

    @GetMapping("/lists")
    public QueryFeedListResponse getFeedList() {
        return queryFeedListService.execute();
    }

    @GetMapping
    public QueryFeedListResponse getFeedListViews() {
        return queryFeedListViewsService.execute();
    }

    @GetMapping("/{feed-id}")
    public QueryFeedDetailResponse getFeedDetail(@PathVariable("feed-id") Integer feedId) {
        return queryFeedDetailService.execute(feedId);
    }

}
