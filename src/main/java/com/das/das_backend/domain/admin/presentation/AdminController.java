package com.das.das_backend.domain.admin.presentation;

import com.das.das_backend.domain.admin.presentation.dto.request.UpdateStudentInfoRequest;
import com.das.das_backend.domain.admin.service.UpdateStudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final UpdateStudentInfoService updateStudentInfoService;

    @PutMapping
    public void adminModifyUser(@RequestBody @Valid UpdateStudentInfoRequest request) {
        updateStudentInfoService.execute(request);
    }

}
