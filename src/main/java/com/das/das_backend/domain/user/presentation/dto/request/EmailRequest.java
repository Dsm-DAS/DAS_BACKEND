package com.das.das_backend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class EmailRequest {

    @Pattern(regexp = "[a-zA-Z\\d+_.]+@dsm\\.hs\\.kr$", message = "이메일 형식이 맞지 않습니다.")
    private String email;

}
