package com.das.das_backend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 6, max = 20, message = "account_id는 8자 이상 20자 이하여야합니다.")
    private String accountId;

    @NotBlank(message = "email은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,20}$",
            message = "password는 영문, 숫자, 특수기호가 포함되어야 하며 8글자 이상 20글자 이하여야 합니다.")
    private String password;

    @NotBlank(message = "name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 2, max = 10, message = "name은 2자 이상 10자 이하여야합니다.")
    private String name;

    @NotNull(message = "grade는 Null일 수 없습니다.")
    private Integer grade;

    @NotNull(message = "class_num는 Null일 수 없습니다.")
    private Integer classNum;

    @NotNull(message = "number는 Null일 수 없습니다.")
    private Integer number;

}
