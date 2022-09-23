package com.das.das_backend.domain.comment.service;

import com.das.das_backend.domain.comment.domain.Comment;
import com.das.das_backend.domain.comment.exception.CommentCannotUpdateException;
import com.das.das_backend.domain.comment.facade.CommentFacade;
import com.das.das_backend.domain.comment.presentation.dto.request.UpdateCommentRequest;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@RequiredArgsConstructor
@Service
public class UpdateCommentService {

    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Transactional
    public void modifyComment(Integer commentId, UpdateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getComment(commentId);

        if(!user.equals(comment.getUser())) {
            throw CommentCannotUpdateException.EXCEPTION;
        }

        comment.modifyComment(request.getComment());
    }
}
