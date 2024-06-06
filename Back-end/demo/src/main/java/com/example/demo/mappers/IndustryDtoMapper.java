package com.example.demo.mappers;


import com.example.demo.Dto.IndustryDto;
import com.example.demo.model.Industry;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IndustryDtoMapper {

    private final ModelMapper modelMapper;

    public IndustryDto toDto(Industry industry) {
        return modelMapper.map(industry, IndustryDto.class);
    }

    public Industry toEntity(IndustryDto industryDto) {
        return modelMapper.map(industryDto, Industry.class);
    }
}
