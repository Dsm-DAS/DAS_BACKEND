package com.das.das_backend.domain.teacher.service;

import com.das.das_backend.domain.teacher.presentation.dto.request.UpdateStudentInfoRequest;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.domain.repository.UserRepository;
import com.das.das_backend.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateStudentInfoService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(UpdateStudentInfoRequest request) {
        User targetUser = userRepository.findById(request.getTargetUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        targetUser.teacherModifyUser(request.getName(), request.getGrade(),
                request.getClassNum(), request.getNumber());
    }

}
