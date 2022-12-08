package com.das.das_backend.domain.notice.domain.repository;

import com.das.das_backend.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice, Integer> {

    List<Notice> findAllByOrderByCreatedAtDesc();

}
