package com.military.jobfinder.repository;

import com.military.jobfinder.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {
    List<Api> findByCompanyName(String companyName);

    // 우선 업체명, 공고제목만 가능하게 함.
    @Query("SELECT a FROM Api a WHERE " +
            "(?1 IS NULL OR a.companyName LIKE %?1%) AND " +
            "(?2 IS NULL OR a.recruitTitle LIKE %?2%)")
    List<Api> findByParams(String companyName, String recruitTitle);
}
