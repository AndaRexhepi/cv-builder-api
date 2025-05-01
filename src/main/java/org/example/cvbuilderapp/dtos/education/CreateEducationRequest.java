package org.example.cvbuilderapp.dtos.education;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEducationRequest {
    private String degree;
    private String school;
    private Float gpa;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Boolean isPresent;
    private Resume resume;
}
