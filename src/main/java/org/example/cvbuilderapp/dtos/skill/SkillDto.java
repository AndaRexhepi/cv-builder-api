package org.example.cvbuilderapp.dtos.skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {
     private Long id;
     private String skill;
}
