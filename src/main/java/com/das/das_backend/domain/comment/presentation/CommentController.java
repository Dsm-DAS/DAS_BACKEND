package com.das.das_backend.domain.comment.presentation;

import com.das.das_backend.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.das.das_backend.domain.comment.presentation.dto.request.UpdateCommentRequest;
import com.das.das_backend.domain.comment.service.CreateCommentService;
import com.das.das_backend.domain.comment.service.DeleteCommentService;
import com.das.das_backend.domain.comment.service.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;
    private final UpdateCommentService updateCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void createComment(@PathVariable("feed-id") Integer feedId,
                              @RequestBody @Valid CreateCommentRequest request) {
        createCommentService.createComment(feedId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{comment-id}")
    public void modifyComment(@PathVariable("comment-id") Integer commentId,
                              @RequestBody @Valid UpdateCommentRequest request) {
        updateCommentService.modifyComment(commentId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") Integer commentId) {
        deleteCommentService.deleteComment(commentId);
    }

}
