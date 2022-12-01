package com.das.das_backend.domain.club.domain.repository;

import com.das.das_backend.domain.club.domain.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {
}
