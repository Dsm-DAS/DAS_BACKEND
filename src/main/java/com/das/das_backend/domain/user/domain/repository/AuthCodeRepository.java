package com.das.das_backend.domain.user.domain.repository;

import com.das.das_backend.domain.user.domain.AuthCode;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}
