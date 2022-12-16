package com.das.das_backend.domain.club.presentation.dto.response;

import com.das.das_backend.domain.club.domain.types.ClubCategory;
import com.das.das_backend.domain.club.domain.types.ClubType;
import com.das.das_backend.domain.user.presentation.dto.response.QueryUserElement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QueryClubDetailResponse {

    private final Integer clubId;
    private final String clubName;
    private final String clubImageUrl;
    private final String clubIntroduce;
    private final ClubType clubType;
    private final ClubCategory clubCategory;
    private final Integer clubViews;
    private final Integer likeCounts;
    private final List<QueryUserElement> usersList;
}
