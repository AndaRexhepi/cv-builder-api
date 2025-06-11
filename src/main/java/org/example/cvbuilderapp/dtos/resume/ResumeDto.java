package org.example.cvbuilderapp.dtos.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

    private Long id;
    private Long profileId;
    private Long objectiveId;
    private String title;
    private List<Long> educationIds = new ArrayList<>();
    private List<Long> experienceIds = new ArrayList<>();
    private List<Long> skillIds = new ArrayList<>();
    private List<Long> pursuitIds = new ArrayList<>();
    private List<Long> referenceIds = new ArrayList<>();
    private List<Long> accoladeIds = new ArrayList<>();
}
