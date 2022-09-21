package com.das.das_backend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSignInRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
