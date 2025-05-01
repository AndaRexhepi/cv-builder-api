package org.example.cvbuilderapp.dtos.skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSkillRequest {
    private String skill;
    private Resume resume;
}
