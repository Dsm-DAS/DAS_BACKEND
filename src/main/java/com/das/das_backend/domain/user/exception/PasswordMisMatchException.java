package com.das.das_backend.domain.user.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class PasswordMisMatchException extends DasException {

    public static final DasException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }

}
