package com.das.das_backend.domain.comment.facade;

import com.das.das_backend.domain.comment.domain.Comment;
import com.das.das_backend.domain.comment.domain.repository.CommentRepository;
import com.das.das_backend.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getComment(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

}