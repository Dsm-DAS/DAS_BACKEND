package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.domain.repository.UserRepository;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserWithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        userRepository.delete(user);
    }

}
