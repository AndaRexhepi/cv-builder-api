package org.example.cvbuilderapp.dtos.referee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRefereeRequest {
    private String fullName;
    private String relationship;
    private String jobTitle;
    private String description;
}
