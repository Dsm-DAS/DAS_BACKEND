package com.das.das_backend.domain.user.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class InvalidAuthCodeException extends DasException {

    public static final DasException EXCEPTION =
            new InvalidAuthCodeException();

    private InvalidAuthCodeException() {
        super(ErrorCode.INVALID_AUTH_CODE);
    }

}
