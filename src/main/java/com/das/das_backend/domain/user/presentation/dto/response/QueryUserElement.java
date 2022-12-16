package com.das.das_backend.domain.user.presentation.dto.response;

import com.das.das_backend.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserElement {

    private final String name;
    private final Integer userId;
    private final String profileImageUrl;

    public static QueryUserElement of(User user) {
        return QueryUserElement.builder()
                .name(user.getName())
                .userId(user.getId())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }

}
