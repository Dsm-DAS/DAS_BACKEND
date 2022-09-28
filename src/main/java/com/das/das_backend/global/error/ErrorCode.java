package com.das.das_backend.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    WRONG_EMAIL(400, "Wrong Email"),
    IMAGE_VALUE_NOT_FOUND(400, "Image Value Not Found"),
    SAVE_IMAGE_FAILED(400, "Save Image Failed"),

    INVALID_TOKEN(401, "Invalid Token"),
    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),
    EXPIRED_TOKEN(401, "Expired_Token"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    FEED_CANNOT_UPDATE(401, "Feed Cannot Update"),
    FEED_CANNOT_DELETE(401, "Feed Cannot Delete"),

    INVALID_AUTH_CODE(401, "Invalid Auth Code"),
    UNVERIFIED_AUTH_CODE(401, "UnVerified Auth Code"),
    COMMENT_CANNOT_DELETE(401,"Comment Cannot Delete"),
    COMMENT_CANNOT_UPDATE(401,"Comment Cannot Update"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    COMMENT_NOT_FOUND(404,"Comment Cannot Found"),
    SEND_CODE_FAILED(404, "Send Code Failed"),

    USER_ALREADY_EXISTS(409, "User Already Exists"),
    LIKE_EXIST(409, "Like Exist"),
    REMOVE_LIKE_EXIST(409, "Remove Like Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
