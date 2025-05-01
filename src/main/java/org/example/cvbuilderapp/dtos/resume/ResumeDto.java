package org.example.cvbuilderapp.dtos.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

    private Long id;
//    private User user;
    private Profile profile;
    private Objective objective;
    private List<Education> education;
    private List<Experience> experience;
    private List<Skill> skill;
    private List<Pursuit> pursuit;
    private List<Referee> reference;
    private List<Accolade> accolade;
}
