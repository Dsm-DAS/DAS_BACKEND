package com.das.das_backend.global.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class SaveImageFailedException extends DasException {

    public static final DasException EXCEPTION =
            new SaveImageFailedException();

    private SaveImageFailedException() {
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }

}
