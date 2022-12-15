package com.das.das_backend.domain.club.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class ClubAlreadyExistsException extends DasException {

    public static final DasException EXCEPTION =
            new ClubAlreadyExistsException();

    private ClubAlreadyExistsException() {
        super(ErrorCode.CLUB_ALREADY_EXISTS);
    }

}
