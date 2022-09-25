package com.das.das_backend.domain.like.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class LikeExistException extends DasException {

    public static final DasException EXCEPTION =
            new LikeExistException();

    private LikeExistException() {
        super(ErrorCode.LIKE_EXIST);
    }

}
