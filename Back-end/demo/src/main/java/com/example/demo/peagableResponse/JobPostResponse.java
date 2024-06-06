package com.example.demo.peagableResponse;


import com.example.demo.Dto.JobPostDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobPostResponse {

    private List<JobPostDto> content;
    private Integer totalPages;
    private Integer currentPage;
    private Integer pageSize;
    private Boolean lastPage;
}
