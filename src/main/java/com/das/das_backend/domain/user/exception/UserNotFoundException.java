package com.das.das_backend.domain.user.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class UserNotFoundException extends DasException {

    public static final DasException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
