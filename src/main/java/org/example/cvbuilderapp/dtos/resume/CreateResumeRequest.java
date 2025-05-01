package org.example.cvbuilderapp.dtos.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResumeRequest {

    private Long userId;
    private Long profileId;
    private Long objectiveId;
    private List<Long> educationIds;
    private List<Long> experienceIds;
    private List<Long> skillIds;
    private List<Long> pursuitIds;
    private List<Long> referenceIds;
    private List<Long> accoladeIds;
}
