package com.das.das_backend.domain.user.presentation.dto.response;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.user.domain.types.LinkInfo;
import com.das.das_backend.global.enums.Major;
import com.das.das_backend.global.enums.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyInfoResponse {

    private final Integer userId;

    private final String email;

    private final String name;

    private final Integer grade;

    private final Integer classNum;

    private final Integer number;

    private final String introduce;

    private final String profileImageUrl;

    private final Integer viewCounts;

    private final Major major;

    private final String stack;

    private final LinkInfo linkInfo;

    private final Sex sex;

    private final String region;

    private final Club club;

}
