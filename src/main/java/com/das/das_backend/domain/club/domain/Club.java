package com.das.das_backend.domain.club.domain;

import com.das.das_backend.domain.club.domain.types.ClubCategory;
import com.das.das_backend.domain.club.domain.types.ClubType;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.global.entity.BaseIdEntity;
import com.das.das_backend.infrastructure.s3.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Entity
public class Club extends BaseIdEntity {

    @NotNull
    @Size(max = 20)
    private String clubName;

    @NotNull
    @Size(max = 100)
    private String clubIntroduce;

    @NotNull
    private ClubCategory clubCategory;

    @NotNull
    private ClubType clubType;

    @NotNull
    private String clubUrl;

    @NotNull
    private Integer clubViews;

    @ColumnDefault(DefaultImage.CLUB_PROFILE_IMAGE)
    @Column(nullable = false)
    private String clubImageUrl;

    @OneToMany(mappedBy = "club")
    private List<User> userList;

    @Builder
    public Club(String clubName, String clubIntroduce, ClubCategory clubCategory, ClubType clubType,
                String clubUrl, Integer clubViews, String clubImageUrl) {
        this.clubName = clubName;
        this.clubIntroduce = clubIntroduce;
        this.clubCategory = clubCategory;
        this.clubType = clubType;
        this.clubUrl = clubUrl;
        this.clubViews = clubViews;
        this.clubImageUrl = clubImageUrl;
    }

}
