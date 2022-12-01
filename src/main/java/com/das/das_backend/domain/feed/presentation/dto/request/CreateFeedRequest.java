package com.das.das_backend.domain.feed.presentation.dto.request;

import com.das.das_backend.global.enums.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;

    @NotBlank
    @Size(min = 1, max = 1000)
    private String content;

    @NotBlank
    @Size(max = 500)
    private String dasUrl;

    @NotNull
    private Major major;

    @NotNull
    private LocalDateTime endAt;

}
