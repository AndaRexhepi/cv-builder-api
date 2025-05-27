package org.example.cvbuilderapp.dtos.experience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {
    private Long id;
    private String title;
    private String company;
    private String employmentType;
    private String location;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isPresent;

}
