package org.example.cvbuilderapp.dtos.pursuit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePursuitRequest {
    private String pursuit;
    private Resume resume;
}
