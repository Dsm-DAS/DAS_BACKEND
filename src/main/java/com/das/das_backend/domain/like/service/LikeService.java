package com.das.das_backend.domain.like.service;

import com.das.das_backend.domain.club.domain.Club;
import com.das.das_backend.domain.club.facade.ClubFacade;
import com.das.das_backend.domain.like.domain.Like;
import com.das.das_backend.domain.like.domain.repository.LikeRepository;
import com.das.das_backend.domain.like.exception.LikeExistException;
import com.das.das_backend.domain.like.exception.RemoveLikeExistException;
import com.das.das_backend.domain.like.facade.LikeFacade;
import com.das.das_backend.domain.like.presentation.dto.response.LikeResponse;
import com.das.das_backend.domain.user.domain.User;
import com.das.das_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final ClubFacade clubFacade;
    private final LikeFacade likeFacade;

    @Transactional
    public LikeResponse liked(Integer clubId) {
        User user = userFacade.getCurrentUser();
        Club club = clubFacade.getClub(clubId);

        if (likeFacade.checkLiked(user, club)) {
            throw LikeExistException.EXCEPTION;
        }

        club.addLikeCount();
        return addLike(user, club);
    }

    @Transactional
    public LikeResponse deleteLiked(Integer clubId) {
        User user = userFacade.getCurrentUser();
        Club club = clubFacade.getClub(clubId);

        if (!likeFacade.checkLiked(user, club)) {
            throw RemoveLikeExistException.EXCEPTION;
        }

        club.subLikeCount();
        return removeLike(user, club);
    }

    private LikeResponse addLike(User user, Club club) {
        likeRepository.save(Like.builder()
                .user(user)
                .club(club)
                .build());

        return LikeResponse.builder()
                .likeCounts(club.getLikeCounts())
                .liked(likeFacade.checkLiked(user, club))
                .build();
    }

    private LikeResponse removeLike(User user, Club club) {
        likeRepository.deleteByUserAndClub(user, club);

        return LikeResponse.builder()
                .likeCounts(club.getLikeCounts())
                .liked(likeFacade.checkLiked(user, club))
                .build();
    }

}
