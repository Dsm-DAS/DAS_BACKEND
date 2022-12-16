package com.das.das_backend.domain.club.presentation;

import com.das.das_backend.domain.club.presentation.dto.request.CreateClubRequest;
import com.das.das_backend.domain.club.presentation.dto.request.UpdateClubRequest;
import com.das.das_backend.domain.club.service.CreateClubService;
import com.das.das_backend.domain.club.service.UpdateClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/club")
@RestController
public class ClubController {

    private final CreateClubService createClubService;
    private final UpdateClubService updateClubService;

    @PostMapping
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.execute(request);
    }

    @PutMapping("/{club-id}")
    public void updateClub(@PathVariable("club-id") Integer clubId,
                           @RequestBody @Valid UpdateClubRequest request) {
        updateClubService.exceute(clubId, request);
    }

}
