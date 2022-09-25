package com.das.das_backend.domain.like.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class RemoveLikeExistException extends DasException {

    public static final DasException EXCEPTION =
            new RemoveLikeExistException();

    private RemoveLikeExistException() {
        super(ErrorCode.REMOVE_LIKE_EXIST);
    }

}
