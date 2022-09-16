package com.das.das_backend.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DasException extends RuntimeException {

    private final ErrorCode errorCode;

}
