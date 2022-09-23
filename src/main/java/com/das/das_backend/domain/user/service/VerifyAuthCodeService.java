package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.user.domain.AuthCode;
import com.das.das_backend.domain.user.domain.repository.AuthCodeRepository;
import com.das.das_backend.domain.user.exception.InvalidAuthCodeException;
import com.das.das_backend.domain.user.facade.AuthCodeFacade;
import com.das.das_backend.domain.user.presentation.dto.request.VerifyAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VerifyAuthCodeService {

    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(VerifyAuthCodeRequest request) {

        String email = request.getEmail();
        String code = request.getCode();

        AuthCode authCode = authCodeFacade.getAuthCodeById(email);

        if(authCode.isVerify() || !authCode.getCode().equals(code)) {
            throw InvalidAuthCodeException.EXCEPTION;
        }

        authCode.changeVerify();
    }

}
