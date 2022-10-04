package com.das.das_backend.domain.user.presentation;

import com.das.das_backend.domain.user.presentation.dto.request.*;
import com.das.das_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.das.das_backend.domain.user.presentation.dto.response.TokenResponse;
import com.das.das_backend.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignInService userSignInService;
    private final TokenRefreshService tokenRefreshService;
    private final UserSignUpService userSignUpService;
    private final ChangePasswordService changePasswordService;
    private final LogoutService logoutService;
    private final UserWithdrawalService userWithdrawalService;
    private final AuthCodeService authCodeService;
    private final VerifyAuthCodeService verifyAuthCodeService;
    private final QueryMyInfoService queryMyInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/email")
    public void sendAuthCode(@RequestBody @Valid EmailRequest request) {
        authCodeService.execute(request);
    }

    @PutMapping("/email")
    public void verifyEmail(@RequestBody @Valid VerifyAuthCodeRequest request) {
        verifyAuthCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }

    @PostMapping("/token")
    public TokenResponse signIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

    @PatchMapping("/token")
    public TokenResponse reIssue(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        logoutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteUser() {
        userWithdrawalService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        changePasswordService.execute(request);
    }

    @GetMapping("/mypage")
    public QueryMyInfoResponse getMyInfo() {
        return queryMyInfoService.getMyInfo();
    }

}
