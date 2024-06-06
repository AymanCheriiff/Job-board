package com.example.demo.mappers;


import com.example.demo.Dto.JobPostDto;
import com.example.demo.model.JobPost;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobPostDtoMapper {

    private final ModelMapper modelMapper;

    public JobPostDto toDto(JobPost jobPost) {
        return modelMapper.map(jobPost, JobPostDto.class);
    }

    public JobPost toEntity(JobPostDto jobPostDto) {
        return modelMapper.map(jobPostDto, JobPost.class);
    }
}
