package com.das.das_backend.domain.comment.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    @NotBlank
    @Size(max = 500)
    private String content;

}