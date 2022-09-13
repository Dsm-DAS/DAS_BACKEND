package com.das.das_backend.domain.feed.domain;

import com.das.das_backend.domain.user.domain.User;
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
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 20)
    private String title;

    @NotNull
    @Size(max = 1000)
    private String content;

    @Size(max = 500)
    private String dasUrl;

    @Column(nullable = false)
    private Integer views;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(String title, String content, String dasUrl, Integer views, User user) {
        this.title = title;
        this.content = content;
        this.dasUrl = dasUrl;
        this.views = views;
        this.user = user;
    }

}
