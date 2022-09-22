package com.das.das_backend.domain.feed.exception;

import com.das.das_backend.global.error.DasException;
import com.das.das_backend.global.error.ErrorCode;

public class FeedCannotDeleteException extends DasException {

    public static final DasException EXCEPTION =
            new FeedCannotDeleteException();

    private FeedCannotDeleteException() {
        super(ErrorCode.FEED_CANNOT_DELETE);
    }

}
