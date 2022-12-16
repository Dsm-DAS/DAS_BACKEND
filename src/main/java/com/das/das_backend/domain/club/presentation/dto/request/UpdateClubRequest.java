package com.das.das_backend.domain.club.presentation.dto.request;

import com.das.das_backend.domain.club.domain.types.ClubCategory;
import com.das.das_backend.domain.club.domain.types.ClubType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateClubRequest {

    @NotBlank
    @Size(max = 20)
    private String clubName;

    @NotNull
    private String clubImageUrl;

    @NotNull
    private ClubType clubType;

    @NotNull
    private String clubUrl;

    @NotNull
    private ClubCategory clubCategory;

    @NotNull
    @Size(max = 100)
    private String clubIntroduce;

}
