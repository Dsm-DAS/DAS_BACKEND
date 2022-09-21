package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.domain.repository.UserRepository;
import com.das.das_backend.domain.user.exception.UserAlreadyExistsException;
import com.das.das_backend.domain.user.presentation.dto.request.UserSignUpRequest;
import com.das.das_backend.global.enums.Authority;
import com.das.das_backend.infrastructure.s3.DefaultImage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(UserSignUpRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .authority(Authority.USER)
                .profileImageUrl(DefaultImage.USER_PROFILE_IMAGE)
                .grade(request.getGrade())
                .classNum(request.getClassNum())
                .number(request.getNumber())
                .build());
    }

}