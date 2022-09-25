package com.das.das_backend.domain.like.presentation;

import com.das.das_backend.domain.like.presentation.dto.response.LikeResponse;
import com.das.das_backend.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class LikeController {

    private final LikeService likeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public LikeResponse liked(@PathVariable("feed-id") Integer feedId) {
            return likeService.liked(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public LikeResponse deleteLiked(@PathVariable("feed-id") Integer feedId) {
        return likeService.deleteLiked(feedId);
    }

}
