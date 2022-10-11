package com.das.das_backend.domain.user.domain;

import com.das.das_backend.global.entity.BaseIdEntity;
import com.das.das_backend.global.enums.Authority;
import com.das.das_backend.infrastructure.s3.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Entity
public class User extends BaseIdEntity {

    @NotNull
    @Size(max = 64)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 10)
    private String name;

    @NotNull
    @Max(3)
    private Integer grade;

    @NotNull
    @Max(4)
    private Integer classNum;

    @NotNull
    @Max(20)
    private Integer number;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    @Column(nullable = false)
    private String profileImageUrl;

    @Size(max = 50)
    private String introduce;

    @NotNull
    private Integer viewCounts;

    @Builder
    public User(String email, String password, String name, Integer grade, Integer classNum,
                Integer number, Authority authority, String profileImageUrl, String introduce, Integer viewCounts) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.classNum = classNum;
        this.number = number;
        this.authority = authority;
        this.profileImageUrl = profileImageUrl;
        this.introduce = introduce;
        this.viewCounts = viewCounts;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void modifyInfo(String name, String introduce, String profileImageUrl) {
        this.name = name;
        this.introduce = introduce;
        this.profileImageUrl = profileImageUrl;
    }

    public void teacherModifyUser(String name, Integer grade, Integer classNum, Integer number) {
        this.name = name;
        this.grade = grade;
        this.classNum = classNum;
        this.number = number;
    }

    public void addViews() {
        this.viewCounts += 1;
    }

}
