package com.das.das_backend.domain.teacher.service;

import com.das.das_backend.domain.teacher.presentation.dto.request.UpdateStudentInfoRequest;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateStudentInfoService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateStudentInfoRequest request) {
        User user = userFacade.getCurrentUser();

        user.teacherModifyUser(request.getName(), request.getGrade(),
                request.getClassNum(), request.getNumber());
    }

}
