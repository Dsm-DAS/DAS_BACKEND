package com.das.das_backend.domain.user.facade;

import com.das.das_backend.domain.user.domain.AuthCode;
import com.das.das_backend.domain.user.domain.repository.AuthCodeRepository;
import com.das.das_backend.domain.user.exception.InvalidAuthCodeException;
import com.das.das_backend.domain.user.exception.UnVerifiedAuthCodeException;
import com.das.das_backend.domain.user.exception.WrongEmailException;
import com.das.das_backend.global.util.JmsUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthCodeFacade {

    private final AuthCodeRepository authCodeRepository;
    private final JmsUtil jmsUtil;

    public AuthCode getAuthCodeById(String email) {
        return authCodeRepository.findById(email)
                .orElseThrow(() -> InvalidAuthCodeException.EXCEPTION);
    }

    public void isVerify(String email) {
        if(getAuthCodeById(email).isVerify()) {
            throw UnVerifiedAuthCodeException.EXCEPTION;
        }
    }

    public void sendEmail(String email) {

        if(!isValid(email)) {
            throw WrongEmailException.EXCEPTION;
        }

        String code = createKey();
        jmsUtil.sendEmail(email, code);

        authCodeRepository.save(AuthCode.builder()
                .email(email)
                .code(code)
                .build());
    }

    private boolean isValid(String email) {
        return email.endsWith("@dsm.hs.kr");
    }

    private String createKey() {
        return RandomStringUtils.randomNumeric(6);
    }

}
