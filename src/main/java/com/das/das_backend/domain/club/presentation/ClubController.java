package com.das.das_backend.domain.club.presentation;

import com.das.das_backend.domain.club.presentation.dto.request.CreateClubRequest;
import com.das.das_backend.domain.club.service.CreateClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/club")
@RestController
public class ClubController {

    private final CreateClubService createClubService;

    @PostMapping
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.execute(request);
    }

}
