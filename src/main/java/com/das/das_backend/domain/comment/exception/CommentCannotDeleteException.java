package com.das.das_backend.domain.comment.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class CommentCannotDeleteException extends DasException {

    public static final DasException EXCEPTION =
            new CommentCannotDeleteException();

    private CommentCannotDeleteException() {
        super(ErrorCode.COMMENT_CANNOT_DELETE);
    }

}
