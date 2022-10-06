package com.das.das_backend.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateStudentInfoRequest {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    private Integer targetUserId;

    @NotNull
    private Integer grade;

    @NotNull
    private Integer classNum;

    @NotNull
    private Integer number;

}
