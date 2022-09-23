package com.das.das_backend.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    WRONG_EMAIL(400, "Wrong Email"),

    INVALID_TOKEN(401, "Invalid Token"),
    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),
    EXPIRED_TOKEN(401, "Expired_Token"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    FEED_CANNOT_UPDATE(401, "Feed Cannot Update"),
    FEED_CANNOT_DELETE(401, "Feed Cannot Delete"),
    INVALID_AUTH_CODE(401, "Invalid Auth Code"),
    UNVERIFIED_AUTH_CODE(401, "UnVerified Auth Code"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),

    USER_ALREADY_EXISTS(409, "User Already Exists"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
