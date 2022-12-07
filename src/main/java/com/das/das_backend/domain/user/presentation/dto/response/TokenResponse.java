package com.das.das_backend.domain.user.presentation.dto.response;

import com.das.das_backend.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {

    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
    private final LocalDateTime expiredAt;

}
