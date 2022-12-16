package com.das.das_backend.domain.club.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryClubListResponse {

    private List<QueryClubElement> clubList;

}
