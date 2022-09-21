package com.das.das_backend.domain.user.presentation;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.das.das_backend.domain.user.presentation.dto.request.UserSignUpRequest;
import com.das.das_backend.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    
    private final UserSignUpService userSignUpService;




    @PostMapping("/signup")
    public void signup(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }
}
