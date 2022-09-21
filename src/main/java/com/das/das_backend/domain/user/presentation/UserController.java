package com.das.das_backend.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.das.das_backend.domain.user.presentation.dto.request.UserSignUpRequest;
import com.das.das_backend.domain.user.service.UserSignUpService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }

    private final UserSignUpService userSignUpService;




}
