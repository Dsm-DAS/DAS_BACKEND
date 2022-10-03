package com.das.das_backend.domain.user.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class UserExistException extends DasException {

    public static final DasException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
