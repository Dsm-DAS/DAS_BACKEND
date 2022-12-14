package com.das.das_backend.domain.club.service;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.club.domain.repository.ClubRepository;
import com.das.das_backend.domain.club.exception.ClubAlreadyExistsException;
import com.das.das_backend.domain.club.facade.ClubFacade;
import com.das.das_backend.domain.club.presentation.dto.request.CreateClubRequest;
import com.das.das_backend.infrastructure.s3.DefaultImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateClubService {

    private final ClubRepository clubRepository;
    private final ClubFacade clubFacade;

    public void execute(CreateClubRequest request) {

        if(clubFacade.isAlreadyClubName(request.getClubName())) {
            throw ClubAlreadyExistsException.EXCEPTION;
        }

       clubRepository.save(Club
               .builder()
               .clubName(request.getClubName())
               .clubType(request.getClubType())
               .clubCategory(request.getClubCategory())
               .clubImageUrl(DefaultImage.CLUB_PROFILE_IMAGE)
               .clubViews(0)
               .likeCounts(0)
               .build());
    }

}
