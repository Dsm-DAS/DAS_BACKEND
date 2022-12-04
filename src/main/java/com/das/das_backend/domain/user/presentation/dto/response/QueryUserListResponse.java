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
        public final Integer userId;
        public final String name;
        public final String profileImageUrl;
        public final Integer viewCounts;
        public final Integer grade;
        public final Integer classNum;
    }

}
