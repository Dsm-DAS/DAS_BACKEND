package com.das.das_backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WriterResponse {

    private final Integer userId;

    private final String name;

    private final String profileImageUrl;

}
