package com.das.das_backend.domain.club.presentation;

import com.das.das_backend.domain.club.presentation.dto.request.CreateClubRequest;
import com.das.das_backend.domain.club.presentation.dto.request.UpdateClubRequest;
import com.das.das_backend.domain.club.presentation.dto.response.QueryClubListResponse;
import com.das.das_backend.domain.club.service.CreateClubService;
import com.das.das_backend.domain.club.service.DeleteClubService;
import com.das.das_backend.domain.club.service.QueryClubListService;
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
    private final DeleteClubService deleteClubService;
    private final QueryClubListService queryClubListService;

    @PostMapping
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.execute(request);
    }

    @PutMapping("/{club-id}")
    public void updateClub(@PathVariable("club-id") Integer clubId,
                           @RequestBody @Valid UpdateClubRequest request) {
        updateClubService.exceute(clubId, request);
    }

    @DeleteMapping("/{club-id}")
    public void deleteClub(@PathVariable("club-id") Integer clubId) {
        deleteClubService.execute(clubId);
    }

    @GetMapping("/lists")
    public QueryClubListResponse queryClubList() {
        return queryClubListService.execute();
    }
    
}
