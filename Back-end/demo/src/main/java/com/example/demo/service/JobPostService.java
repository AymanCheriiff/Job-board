package com.example.demo.service;


import com.example.demo.Dto.JobPostDto;
import com.example.demo.mappers.JobPostDtoMapper;
import com.example.demo.model.JobPost;
import com.example.demo.peagableResponse.JobPostResponse;
import com.example.demo.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;
    private final JobPostDtoMapper jobPostDtoMapper;

    public JobPostResponse getJobPostByUserId(UUID id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<JobPost> jobPosts = jobPostRepository.findByUserId(id, pageable);
        List<JobPostDto> jobPostDtoList = jobPosts.stream().map(jobPostDtoMapper::toDto).toList();
        JobPostResponse jobPostResponse = new JobPostResponse();
        jobPostResponse.setContent(jobPostDtoList);
        jobPostResponse.setCurrentPage(jobPosts.getNumber());
        jobPostResponse.setTotalPages(jobPosts.getTotalPages());
        jobPostResponse.setPageSize(jobPosts.getNumberOfElements());
        return jobPostResponse;
    }

    public JobPostResponse getJobPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<JobPost> jobPosts = jobPostRepository.findAll(pageable);
        List<JobPostDto> jobPostDtoList = jobPosts.stream().map(jobPostDtoMapper::toDto).toList();
        JobPostResponse jobPostResponse = new JobPostResponse();
        jobPostResponse.setContent(jobPostDtoList);
        jobPostResponse.setCurrentPage(jobPosts.getNumber());
        jobPostResponse.setTotalPages(jobPosts.getTotalPages());
        jobPostResponse.setPageSize(jobPosts.getNumberOfElements());
        return jobPostResponse;
    }

    public JobPostResponse getJobPostsByUserIdAndIndustry(UUID id, String industry, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<JobPost> jobPosts = jobPostRepository.findByUserIdAndIndustry(id, industry, pageable);
        List<JobPostDto> jobPostDtoList = jobPosts.stream().map(jobPostDtoMapper::toDto).toList();
        JobPostResponse jobPostResponse = new JobPostResponse();
        jobPostResponse.setContent(jobPostDtoList);
        jobPostResponse.setCurrentPage(jobPosts.getNumber());
        jobPostResponse.setTotalPages(jobPosts.getTotalPages());
        jobPostResponse.setPageSize(jobPosts.getNumberOfElements());
        return jobPostResponse;
    }

    public JobPostResponse getJobPostsByIndustry(String industry, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<JobPost> jobPosts = jobPostRepository.findByIndustry(industry, pageable);
        List<JobPostDto> jobPostDtoList = jobPosts.stream().map(jobPostDtoMapper::toDto).toList();
        JobPostResponse jobPostResponse = new JobPostResponse();
        jobPostResponse.setContent(jobPostDtoList);
        jobPostResponse.setCurrentPage(jobPosts.getNumber());
        jobPostResponse.setTotalPages(jobPosts.getTotalPages());
        jobPostResponse.setPageSize(jobPosts.getNumberOfElements());
        return jobPostResponse;
    }

    public ResponseEntity<?> createNewJobPost(JobPostDto jobPostDto) {
        JobPost jobPost = jobPostDtoMapper.toEntity(jobPostDto);
        jobPostRepository.save(jobPost);
        return ResponseEntity.ok("Job post created");
    }

    public ResponseEntity<?> updateJobPost(JobPostDto jobPostDto) {
        JobPost jobPost = jobPostDtoMapper.toEntity(jobPostDto);
        jobPostRepository.save(jobPost);
        return ResponseEntity.ok("Job post updated");
    }

    public ResponseEntity<?> deleteJobPost(UUID id) {
        jobPostRepository.deleteById(id);
        return ResponseEntity.ok("Job post deleted");
    }
}
