package com.das.das_backend.domain.user.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class UnVerifiedAuthCodeException extends DasException {

    public static final DasException EXCEPTION =
            new UnVerifiedAuthCodeException();

    private UnVerifiedAuthCodeException() {
        super(ErrorCode.UNVERIFIED_AUTH_CODE);
    }

}
