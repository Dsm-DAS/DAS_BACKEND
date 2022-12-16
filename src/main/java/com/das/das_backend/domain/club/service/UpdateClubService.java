package com.das.das_backend.domain.club.service;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.club.facade.ClubFacade;
import com.das.das_backend.domain.club.presentation.dto.request.UpdateClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateClubService {

    private final ClubFacade clubFacade;

    @Transactional
    public void exceute(Integer clubId, UpdateClubRequest request) {

        Club club = clubFacade.getClub(clubId);

        club.modifyClub(request.getClubName(),
                request.getClubImageUrl(),
                request.getClubType(),
                request.getClubUrl(),
                request.getClubCategory(),
                request.getClubIntroduce());
    }

}
