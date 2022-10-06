package com.das.das_backend.domain.teacher.presentation;

import com.das.das_backend.domain.teacher.presentation.dto.request.UpdateStudentInfoRequest;
import com.das.das_backend.domain.teacher.service.UpdateStudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/teacher")
@RestController
public class TeacherController {

    private final UpdateStudentInfoService updateStudentInfoService;

    @PutMapping
    public void teacherModifyUser(@RequestBody @Valid UpdateStudentInfoRequest request) {
        updateStudentInfoService.execute(request);
    }

}
