package com.das.das_backend.global.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class ImageValueNotFoundException extends DasException {

    public static DasException EXCEPTION =
            new ImageValueNotFoundException();

    private ImageValueNotFoundException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }

}
