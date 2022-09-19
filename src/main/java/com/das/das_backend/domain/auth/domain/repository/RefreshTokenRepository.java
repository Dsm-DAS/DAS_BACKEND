package com.das.das_backend.domain.auth.domain.repository;

import com.das.das_backend.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
