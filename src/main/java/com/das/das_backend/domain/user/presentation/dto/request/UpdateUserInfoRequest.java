package com.das.das_backend.domain.user.presentation.dto.request;

import com.das.das_backend.domain.user.domain.types.LinkInfo;
import com.das.das_backend.global.enums.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @Size(min = 1, max = 50)
    private String introduce;

    @NotBlank
    private String profileImageUrl;

    private Major major;

    @Size(max = 10)
    private String region;

    private LinkInfo linkInfo;

}
