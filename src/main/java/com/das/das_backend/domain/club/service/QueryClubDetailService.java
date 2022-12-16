package com.das.das_backend.domain.club.service;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.club.facade.ClubFacade;
import com.das.das_backend.domain.club.presentation.dto.response.QueryClubDetailResponse;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryClubDetailService {

    private final ClubFacade clubFacade;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryClubDetailResponse execute(Integer clubId) {
        Club club = clubFacade.getClub(clubId);

        return QueryClubDetailResponse.builder()
                .clubId(club.getId())
                .clubName(club.getClubName())
                .clubImageUrl(club.getClubImageUrl())
                .clubIntroduce(club.getClubIntroduce())
                .clubType(club.getClubType())
                .clubCategory(club.getClubCategory())
                .clubViews(club.getClubViews())
                .likeCounts(club.getLikeCounts())
                .usersList(userFacade.queryUsersList(club))
                .build();
    }

}
