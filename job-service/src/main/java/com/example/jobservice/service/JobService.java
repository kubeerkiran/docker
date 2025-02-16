package com.example.jobservice.service;

import com.example.jobservice.dto.JobDto;
import com.example.jobservice.repository.JobRepository;
import com.example.jobservice.util.EntifyDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public Flux<JobDto> allJobs() {
        return this.repository.findAll()
                .map(EntifyDtoUtil::toDto);
    }

    public Flux<JobDto> jobsBySkillsIn(Set<String> skills) {
        return this.repository.findBySkillsIn(skills)
                .map(EntifyDtoUtil::toDto);
    }

    public Mono<JobDto> save(Mono<JobDto> mono) {
        return mono.map(EntifyDtoUtil::toEntity)
                .flatMap(this.repository::save)
                .map(EntifyDtoUtil::toDto);
    }
}
