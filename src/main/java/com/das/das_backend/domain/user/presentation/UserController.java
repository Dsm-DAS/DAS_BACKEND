package com.das.das_backend.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.das.das_backend.domain.user.presentation.dto.request.UserSignUpRequest;
import com.das.das_backend.domain.user.service.UserSignUpService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }

    private final UserSignUpService userSignUpService;




}
