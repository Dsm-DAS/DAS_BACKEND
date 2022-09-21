package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.refresh_token.domain.RefreshToken;
import com.das.das_backend.domain.refresh_token.domain.repository.RefreshTokenRepository;
import com.das.das_backend.domain.refresh_token.exception.RefreshTokenNotFoundException;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LogoutService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(user.getEmail())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }

}
