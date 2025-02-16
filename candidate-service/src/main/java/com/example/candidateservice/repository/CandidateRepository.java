package com.example.candidateservice.repository;

import com.example.candidateservice.entity.Candidate;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Set;

@Repository
public interface CandidateRepository extends ReactiveCrudRepository<Candidate, String> {

    Flux<Candidate> findBySkillsIn(Set<String> skills);
}
