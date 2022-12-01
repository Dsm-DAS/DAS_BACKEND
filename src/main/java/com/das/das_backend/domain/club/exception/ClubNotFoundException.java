package com.das.das_backend.domain.club.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class ClubNotFoundException extends DasException {

    public static final DasException EXCEPTION =
            new ClubNotFoundException();

    private ClubNotFoundException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }

}
