package com.das.das_backend.domain.club.domain.repository;

import com.das.das_backend.domain.club.domain.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {

    Optional<Club> findByClubName(String clubName);

    List<Club> findAll();

}
