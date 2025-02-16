package com.example.candidateservice.util;

import com.example.candidateservice.dto.CandidateDto;
import com.example.candidateservice.entity.Candidate;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static CandidateDto toDto(Candidate candidate) {
        CandidateDto dto = new CandidateDto();
        BeanUtils.copyProperties(candidate, dto);
        System.out.println("Candidate id:" + dto.getId());
        return dto;
    }

    public static Candidate toEntity(CandidateDto dto) {
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(dto, candidate);
        return candidate;
    }
}
