package com.example.jobservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class JobDto {
    private String id;
    private String description;
    private String company;
    private String salary;
    private Boolean isRemote;
    private Set<String> skills;
}
