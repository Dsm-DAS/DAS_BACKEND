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

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
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
    @Max(1)
    private Integer grade;

    @NotNull
    @Max(1)
    private Integer classNum;

    @NotNull
    @Max(2)
    private Integer number;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    @Column(nullable = false)
    private String profileImageUrl;

    @Size(max = 50)
    private String introduce;

    @Builder
    public User(String email, String password, String name,
                Integer grade, Integer classNum, Integer number, Authority authority, String profileImageUrl, String introduce) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.classNum = classNum;
        this.number = number;
        this.authority = authority;
        this.profileImageUrl = profileImageUrl;
        this.introduce = introduce;
    }

}
