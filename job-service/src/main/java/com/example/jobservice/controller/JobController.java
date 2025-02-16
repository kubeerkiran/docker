package com.example.jobservice.controller;

import com.example.jobservice.dto.JobDto;
import com.example.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    public JobService jobService;

    @GetMapping("/messages")
    public String getMessage() {
        System.out.println("Invoked Controller endpoint: " + System.currentTimeMillis());
        return "Hello from Docker!";
    }

    @GetMapping("all")
    public Flux<JobDto> all() {
        return this.jobService.allJobs();
    }

    @GetMapping("search")
    public Flux<JobDto> search(@RequestParam Set<String> skills) {
        return this.jobService.jobsBySkillsIn(skills);
    }

    @PostMapping
    public Mono<JobDto> save(@RequestBody Mono<JobDto> mono) {
        return this.jobService.save(mono);
    }

}
