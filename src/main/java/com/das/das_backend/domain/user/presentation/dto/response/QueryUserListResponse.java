package com.das.das_backend.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryUserListResponse {

    private final List<UserResponse> userList;

    @Getter
    @Builder
    public static class UserResponse {
        private final Integer userId;
        private final String name;
        private final String profileImageUrl;
        private final Integer viewCounts;
        private final Integer grade;
        private final Integer classNum;
        private final String introduce;
    }

}
