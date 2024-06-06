package com.example.demo.controller;


import com.example.demo.Dto.JobPostDto;
import com.example.demo.peagableResponse.JobPostResponse;
import com.example.demo.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("job_post")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    @PostMapping("save")
    public ResponseEntity<?> createJobPost(@RequestBody JobPostDto jobPostDto) {
        return jobPostService.createNewJobPost(jobPostDto);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateJobPost(@RequestBody JobPostDto jobPostDto) {
        return jobPostService.updateJobPost(jobPostDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteJobPost(@PathVariable UUID id) {
        return jobPostService.deleteJobPost(id);
    }

    @GetMapping("get/user/{id}")
    public JobPostResponse getUserJobPost(
            @PathVariable UUID id,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        return jobPostService.getJobPostByUserId(id, page, size);
    }

    @GetMapping("get/all")
    public JobPostResponse getJobPosts(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        return jobPostService.getJobPosts(page, size);
    }

    @GetMapping("get/user-industry/{id}")
    public JobPostResponse getJobPostsByUserIdAndIndustry(
            @PathVariable UUID id,
            @RequestParam(value = "industry") String industry,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        return jobPostService.getJobPostsByUserIdAndIndustry(id, industry, page, size);
    }

    @GetMapping("get/industry")
    public JobPostResponse getJobPostsByUserIdAndIndustry(
            @RequestParam(value = "industry") String industry,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        return jobPostService.getJobPostsByIndustry(industry, page, size);
    }
}
