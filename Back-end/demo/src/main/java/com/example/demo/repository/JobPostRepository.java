package com.example.demo.repository;

import com.example.demo.model.JobPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface JobPostRepository extends JpaRepository<JobPost, UUID> {

    @Query("select jp from JobPost jp where jp.user.id = :userId")
    Page<JobPost> findByUserId(@Param("userId") UUID userId, Pageable pageable);

    @Query("select jp from JobPost jp where jp.user.id = :userId and jp.industry.name = :industry")
    Page<JobPost> findByUserIdAndIndustry(@Param("userId") UUID userId,
                                          @Param("industry") String industry,
                                          Pageable pageable);

    @Query("select jp from JobPost jp where jp.industry.name = :industry")
    Page<JobPost> findByIndustry(@Param("industry") String industry, Pageable pageable);
}
