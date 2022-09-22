package com.das.das_backend.domain.notice.domain.repository;

import com.das.das_backend.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Integer> {
}
