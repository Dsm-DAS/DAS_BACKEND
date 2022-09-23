package com.das.das_backend.domain.comment.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class CommentCannotUpdateException extends DasException {

    public static final CommentCannotUpdateException EXCEPTION =
            new CommentCannotUpdateException();

    private CommentCannotUpdateException() {
        super(ErrorCode.COMMENT_CANNOT_UPDATE);
    }

}
