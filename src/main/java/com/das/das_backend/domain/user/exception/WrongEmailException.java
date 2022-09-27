package com.das.das_backend.domain.user.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class WrongEmailException extends DasException {

    public static final DasException EXCEPTION =
            new WrongEmailException();

    private WrongEmailException() {
        super(ErrorCode.WRONG_EMAIL);
    }

}
