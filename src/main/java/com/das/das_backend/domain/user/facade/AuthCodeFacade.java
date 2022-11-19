package com.das.das_backend.domain.user.facade;

import com.das.das_backend.domain.user.domain.AuthCode;
import com.das.das_backend.domain.user.domain.repository.AuthCodeRepository;
import com.das.das_backend.domain.user.exception.InvalidAuthCodeException;
import com.das.das_backend.domain.user.exception.UnVerifiedAuthCodeException;
import com.das.das_backend.global.util.jms.JmsProperties;
import com.das.das_backend.global.util.jms.JmsUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthCodeFacade {

    private final AuthCodeRepository authCodeRepository;
    private final JmsProperties jmsProperties;
    private final JmsUtil jmsUtil;

    public AuthCode getAuthCodeById(String email) {
        return authCodeRepository.findById(email)
                .orElseThrow(() -> InvalidAuthCodeException.EXCEPTION);
    }

    public void isVerify(String email) {
        if (getAuthCodeById(email).isVerify()) {
            throw UnVerifiedAuthCodeException.EXCEPTION;
        }
    }

    public void sendEmail(String email) {

        String code = createCode();
        AuthCode authCode = getAuthCode(email, code);
        authCodeRepository.save(authCode);

        jmsUtil.sendEmail(email, code);
    }

    private AuthCode getAuthCode(String email, String code) {
        AuthCode authCode = authCodeRepository.findById(email)
                .orElseGet(() -> createAuthCode(email, code));

        authCode.updateAuthCode(code, jmsProperties.getAuthExp());

        return authCode;
    }

    private AuthCode createAuthCode(String email, String code) {
        return AuthCode.builder()
                .email(email)
                .code(code)
                .isVerify(false)
                .ttl(jmsProperties.getAuthExp())
                .build();
    }

    private String createCode() {
        return RandomStringUtils.randomNumeric(6);
    }

}
