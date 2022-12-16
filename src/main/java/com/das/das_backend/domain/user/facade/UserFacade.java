package com.das.das_backend.domain.user.facade;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.domain.repository.UserRepository;
import com.das.das_backend.domain.user.exception.UserAlreadyExistsException;
import com.das.das_backend.domain.user.exception.UserNotFoundException;
import com.das.das_backend.domain.user.presentation.dto.response.QueryUserElement;
import com.das.das_backend.domain.user.presentation.dto.response.WriterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void isAlreadyExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public WriterResponse getWriter(User writer) {
        return WriterResponse.builder()
                .userId(writer.getId())
                .name(writer.getName())
                .profileImageUrl(writer.getProfileImageUrl())
                .build();
    }

    public List<QueryUserElement> queryUsersList(Club club) {
        return club.getUserList()
                .stream()
                .map(QueryUserElement::of)
                .collect(Collectors.toList());
    }

}
