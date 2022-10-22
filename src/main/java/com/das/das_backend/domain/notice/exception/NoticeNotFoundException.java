package com.das.das_backend.domain.notice.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class NoticeNotFoundException extends DasException {

    public static final DasException EXCEPTION =
            new NoticeNotFoundException();

    private NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }

}
