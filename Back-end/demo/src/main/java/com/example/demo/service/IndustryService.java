package com.example.demo.service;

import com.example.demo.Dto.IndustryDto;
import com.example.demo.mappers.IndustryDtoMapper;
import com.example.demo.model.Industry;
import com.example.demo.repository.IndustryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndustryService {

    private final IndustryRepository industryRepository;
    private final IndustryDtoMapper industryDtoMapper;

    public List<IndustryDto> getAllIndustries() {
        List<Industry> industryList = industryRepository.findAll();
        return industryList.stream().map(industryDtoMapper::toDto).toList();
    }

    public ResponseEntity<?> createIndustry(IndustryDto industryDto) {
        Industry industry = industryDtoMapper.toEntity(industryDto);
        industryRepository.save(industry);
        return ResponseEntity.ok("Industry created successfully");
    }
}
