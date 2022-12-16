package com.das.das_backend.domain.club.presentation.dto.response;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.club.domain.types.ClubCategory;
import com.das.das_backend.domain.club.domain.types.ClubType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryClubElement {

    private final Integer clubId;
    private final String clubName;
    private final String clubImageUrl;
    private final String clubIntroduce;
    private final ClubType clubType;
    private final ClubCategory clubCategory;
    private final Integer likeCounts;

    public static QueryClubElement of(Club club) {
        return QueryClubElement.builder()
                .clubId(club.getId())
                .clubName(club.getClubName())
                .clubImageUrl(club.getClubImageUrl())
                .clubIntroduce(club.getClubIntroduce())
                .clubType(club.getClubType())
                .clubCategory(club.getClubCategory())
                .likeCounts(club.getLikeCounts())
                .build();
    }

}
