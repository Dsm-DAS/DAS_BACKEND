package com.das.das_backend.domain.club.service;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.club.domain.repository.ClubRepository;
import com.das.das_backend.domain.club.facade.ClubFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteClubService {

    private final ClubRepository clubRepository;
    private final ClubFacade clubFacade;

    @Transactional
    public void execute(Integer clubId) {
        Club club = clubFacade.getClub(clubId);

        clubRepository.delete(club);
    }

}
