package com.das.das_backend.domain.user.presentation.dto.response;

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

    private final String introduce;

    private final Integer number;

    private final String profileImageUrl;

    private final Integer viewCounts;
}
