package com.das.das_backend.domain.comment.domain.repository;

import com.das.das_backend.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    
}
