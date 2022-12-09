package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import com.das.das_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryUserInfoService {

    private final UserFacade userFacade;

    @Transactional
    public QueryMyInfoResponse execute(Integer userId) {

        User user = userFacade.getUserById(userId);
        user.addViews();

        return QueryMyInfoResponse.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .grade(user.getGrade())
                .classNum(user.getClassNum())
                .number(user.getNumber())
                .introduce(user.getIntroduce())
                .profileImageUrl(user.getProfileImageUrl())
                .viewCounts(user.getViewCounts())
                .major(user.getMajor())
                .stack(user.getStack())
                .linkInfo(user.getLinkInfo())
                .sex(user.getSex())
                .region(user.getRegion())
                .club(user.getClub())
                .build();
    }

}
