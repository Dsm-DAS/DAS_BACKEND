package com.das.das_backend.domain.user.service;

import com.das.das_backend.domain.feed.presentation.dto.response.QueryFeedListResponse;
import com.das.das_backend.domain.user.domain.repository.UserRepository;
import com.das.das_backend.domain.user.presentation.dto.response.QueryUserListResponse;
import com.das.das_backend.domain.user.presentation.dto.response.QueryUserListResponse.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryUserListService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public QueryUserListResponse execute() {

        List<UserResponse> userList = userRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(user -> UserResponse.builder()
                        .userId(user.getId())
                        .name(user.getName())
                        .profileImageUrl(user.getProfileImageUrl())
                        .viewCounts(user.getViewCounts())
                        .build())
                .collect(Collectors.toList());

        return new QueryUserListResponse(userList);
    }

}
