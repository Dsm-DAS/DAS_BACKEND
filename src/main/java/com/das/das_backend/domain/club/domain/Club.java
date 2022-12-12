package com.das.das_backend.domain.club.domain;

import com.das.das_backend.domain.club.domain.types.ClubCategory;
import com.das.das_backend.domain.club.domain.types.ClubType;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.infrastructure.s3.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String clubName;

    @NotNull
    @Size(max = 100)
    private String clubIntroduce;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ClubCategory clubCategory;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ClubType clubType;

    @NotNull
    private String clubUrl;

    @NotNull
    private Integer clubViews;

    @NotNull
    private Integer likeCounts;

    @ColumnDefault(DefaultImage.CLUB_PROFILE_IMAGE)
    @Column(nullable = false)
    private String clubImageUrl;

    @OneToMany(mappedBy = "club")
    private List<User> userList;

    @Builder
    public Club(String clubName, String clubIntroduce, ClubCategory clubCategory, ClubType clubType,
                String clubUrl, Integer clubViews, String clubImageUrl, Integer likeCounts) {
        this.clubName = clubName;
        this.clubIntroduce = clubIntroduce;
        this.clubCategory = clubCategory;
        this.clubType = clubType;
        this.clubUrl = clubUrl;
        this.clubViews = clubViews;
        this.clubImageUrl = clubImageUrl;
        this.likeCounts = likeCounts;
    }

    public void addLikeCount() {
        this.likeCounts += 1;
    }

    public void subLikeCount() {
        this.likeCounts -= 1;
    }

}
