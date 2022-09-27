package com.das.das_backend.global.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class ExpiredTokenException extends DasException {

    public static final DasException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }

}
