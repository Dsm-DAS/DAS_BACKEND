package com.das.das_backend.domain.club.service;

import com.das.das_backend.domain.club.domain.repository.ClubRepository;
import com.das.das_backend.domain.club.presentation.dto.response.QueryClubElement;
import com.das.das_backend.domain.club.presentation.dto.response.QueryClubListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryClubListService {

    private final ClubRepository clubRepository;

    @Transactional(readOnly = true)
    public QueryClubListResponse execute() {
        return new QueryClubListResponse(
                clubRepository.findAll()
                        .stream()
                        .map(QueryClubElement::of)
                        .collect(Collectors.toList())
        );
    }

}
