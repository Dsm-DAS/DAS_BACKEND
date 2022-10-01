package com.das.das_backend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,20}$", message = "비밀번호는는 8자에서 20자 사이입니다.")
    private String password;

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    private Integer grade;

    @NotNull
    private Integer classNum;

    @NotNull
    private Integer number;

}
