package com.example.demo.controller;


import com.example.demo.Dto.IndustryDto;
import com.example.demo.service.IndustryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("industry")
@RequiredArgsConstructor
public class IndustryController {

    private final IndustryService industryService;


    @GetMapping("get/all")
    public List<IndustryDto> getAllIndustries() {
        return industryService.getAllIndustries();
    }

    @PostMapping("save")
    public ResponseEntity<?> createIndustry(@RequestBody IndustryDto industryDto) {
        return industryService.createIndustry(industryDto);
    }

}
