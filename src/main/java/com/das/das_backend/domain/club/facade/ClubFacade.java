package com.das.das_backend.domain.club.facade;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.club.domain.repository.ClubRepository;
import com.das.das_backend.domain.club.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClubFacade {

    private final ClubRepository clubRepository;

    public Club getClub(Integer clubId) {
        return clubRepository.findById(clubId)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);
    }

}
