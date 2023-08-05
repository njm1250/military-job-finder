package com.military.jobfinder.repository;

import com.military.jobfinder.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {
}
