package com.das.das_backend.global.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class SendCodeFailedException extends DasException {

    public static final DasException EXCEPTION =
            new SendCodeFailedException();

    private SendCodeFailedException() {
        super(ErrorCode.SEND_CODE_FAILED);
    }

}
