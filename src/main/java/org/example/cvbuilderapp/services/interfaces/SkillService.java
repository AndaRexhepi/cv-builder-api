package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.skill.CreateSkillRequest;
import org.example.cvbuilderapp.dtos.skill.SkillDto;
import org.example.cvbuilderapp.dtos.skill.UpdateSkillRequest;
import org.example.cvbuilderapp.entities.Skill;

public interface SkillService extends BaseService<SkillDto, CreateSkillRequest, UpdateSkillRequest, Long>{
}
