package com.das.das_backend.domain.admin.service;

import com.das.das_backend.domain.admin.presentation.dto.request.UpdateStudentInfoRequest;
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
        User targetUser = userFacade.getUserById(request.getTargetUserId());

        targetUser.adminModifyUser(request.getName(),
                request.getGrade(),
                request.getClassNum(),
                request.getNumber());
    }

}
