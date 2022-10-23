package com.das.das_backend.domain.notice.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateNoticeRequest {

    @NotBlank
    @Size(max = 20)
    private String title;

    @NotBlank
    @Size(max = 1000)
    private String content;

}
