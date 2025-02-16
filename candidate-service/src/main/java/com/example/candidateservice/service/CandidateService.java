package com.example.candidateservice.service;

import com.example.candidateservice.dto.CandidateDto;
import com.example.candidateservice.entity.Candidate;
import com.example.candidateservice.repository.CandidateRepository;
import com.example.candidateservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Flux<CandidateDto> getAllCandidates() {
        System.out.println("getAllCandidates");
        return this.candidateRepository.findAll().map(EntityDtoUtil::toDto);
    }

    public Flux<CandidateDto> getCandidateBySkills(Set<String> skills) {
        return this.candidateRepository.findBySkillsIn(skills).map(EntityDtoUtil::toDto);
    }

    public Mono<CandidateDto> saveCandidate(Mono<CandidateDto> candiateDtoMono) {
        return candiateDtoMono.map(EntityDtoUtil::toEntity).flatMap(this.candidateRepository::save).map(EntityDtoUtil::toDto);
    }
}
