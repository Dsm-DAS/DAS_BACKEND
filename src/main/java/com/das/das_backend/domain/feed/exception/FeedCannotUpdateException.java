package com.das.das_backend.domain.feed.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class FeedCannotUpdateException extends DasException {

    public static final DasException EXCEPTION =
            new FeedCannotUpdateException();

    private FeedCannotUpdateException() {
        super(ErrorCode.FEED_CANNOT_UPDATE);
    }

}
