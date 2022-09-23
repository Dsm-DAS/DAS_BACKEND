package com.das.das_backend.domain.comment.service;

import com.das.das_backend.domain.comment.domain.Comment;
import com.das.das_backend.domain.comment.domain.repository.CommentRepository;
import com.das.das_backend.domain.comment.exception.CommentCannotDeleteException;
import com.das.das_backend.domain.comment.facade.CommentFacade;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteCommentService {

    private final UserFacade userFacade;
    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public void deleteComment(Integer commentId) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getComment(commentId);

        if(!user.equals(comment.getUser())) {
            throw CommentCannotDeleteException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }

}
