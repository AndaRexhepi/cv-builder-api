package org.example.cvbuilderapp.dtos.referee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRefereeRequest {
    private String fullName;
    private String relationship;
    private String jobTitle;
    private String description;
    private Long resumeId;
}
