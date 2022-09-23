package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.user.facade.AuthCodeFacade;
import com.das.das_backend.domain.user.facade.UserFacade;
import com.das.das_backend.domain.user.presentation.dto.request.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthCodeService {

    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(EmailRequest request) {

        String email = request.getEmail();

        userFacade.isAlreadyExists(request.getEmail());

        authCodeFacade.sendEmail(email);
    }

}