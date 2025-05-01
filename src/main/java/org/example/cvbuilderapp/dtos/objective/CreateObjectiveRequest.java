package org.example.cvbuilderapp.dtos.objective;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateObjectiveRequest {
    private String objective;
    private Resume resume;
}
