package com.das.das_backend.domain.notice.domain;

import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notice extends BaseTimeIdEntity {

    @NotNull
    @Size(max = 20)
    private String title;

    @NotNull
    @Size(max = 1000)
    private String content;

    @Column(nullable = false)
    private Integer views;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Notice(String title, String content, Integer views, User user) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.user = user;
    }

}
