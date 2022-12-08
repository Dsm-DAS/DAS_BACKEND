package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.refresh_token.domain.RefreshToken;
import com.das.das_backend.domain.refresh_token.domain.repository.RefreshTokenRepository;
import com.das.das_backend.domain.refresh_token.exception.RefreshTokenNotFoundException;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import com.das.das_backend.domain.user.presentation.dto.response.TokenResponse;
import com.das.das_backend.global.security.jwt.JwtProperties;
import com.das.das_backend.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse execute(String refreshToken) {

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getEmail());
        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String newAccessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getEmail());

        User user = userFacade.getUserByEmail(redisRefreshToken.getEmail());

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .authority(user.getAuthority())
                .expiredAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .build();
    }

}
