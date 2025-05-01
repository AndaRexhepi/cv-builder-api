package org.example.cvbuilderapp.dtos.experience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExperienceRequest {
    private String title;
    private String company;
    private String employmentType;
    private String location;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isPresent;
}
