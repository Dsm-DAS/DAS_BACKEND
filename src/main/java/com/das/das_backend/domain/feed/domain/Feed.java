package com.das.das_backend.domain.feed.domain;

import com.das.das_backend.domain.comment.domain.Comment;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.global.enums.Major;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

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

    @NotNull
    @Size(max = 500)
    private String dasUrl;

    @Column(nullable = false)
    private Integer views;

    @Column(nullable = false)
    private LocalDateTime endAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Major major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    @Builder
    public Feed(String title, String content, String dasUrl, Integer views,
                LocalDateTime endAt, Major major, User user) {
        this.title = title;
        this.content = content;
        this.dasUrl = dasUrl;
        this.views = views;
        this.endAt = endAt;
        this.major = major;
        this.user = user;
    }

    public void modifyFeed(String title, String content, String dasUrl) {
        this.title = title;
        this.content = content;
        this.dasUrl = dasUrl;
    }

    public void addViews() {
        this.views += 1;
    }

}
