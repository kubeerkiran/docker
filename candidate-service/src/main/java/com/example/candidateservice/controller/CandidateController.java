package com.example.candidateservice.controller;

import com.example.candidateservice.dto.CandidateDto;
import com.example.candidateservice.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@RestController
@RequestMapping("candidate")
public class CandidateController {

    @Autowired
    public CandidateService candidateService;

    @GetMapping("messages")
    public String getMessage() {
        System.out.println("Invoked Candidate Controller endpoint: " + System.currentTimeMillis());
        return "Hello from Docker!";
    }

    @GetMapping("all")
    public Flux<CandidateDto> getAllCandidates() {
        return this.candidateService.getAllCandidates();
    }

    @GetMapping("search")
    public Flux<CandidateDto> searchBySkills(@RequestParam Set<String> skills) {
        return this.candidateService.getCandidateBySkills(skills);
    }

    @PostMapping("save")
    public Mono<CandidateDto> save(@RequestBody Mono<CandidateDto> candiateDtoMono) {
        return this.candidateService.saveCandidate(candiateDtoMono);
    }


}
