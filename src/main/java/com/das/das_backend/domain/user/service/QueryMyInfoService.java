package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import com.das.das_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryMyInfoResponse getMyInfo() {
        User user = userFacade.getCurrentUser();

        return QueryMyInfoResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .grade(user.getGrade())
                .classNum(user.getClassNum())
                .introduce(user.getIntroduce())
                .number(user.getNumber())
                .ProfileImageUrl(user.getProfileImageUrl())
                .build();
    }

}
