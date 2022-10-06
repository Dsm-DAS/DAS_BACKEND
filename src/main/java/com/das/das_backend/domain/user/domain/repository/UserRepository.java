package com.das.das_backend.domain.user.domain.repository;

import com.das.das_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer userId);

}
