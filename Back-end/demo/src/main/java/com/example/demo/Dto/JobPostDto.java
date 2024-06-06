package com.example.demo.Dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobPostDto {

    private UUID id;
    private String description;
    private String title;
    private String image;
    private UserDto user;
    private IndustryDto industry;
}
