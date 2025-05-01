package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.skill.CreateSkillRequest;
import org.example.cvbuilderapp.dtos.skill.SkillDto;
import org.example.cvbuilderapp.entities.Skill;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillMapper extends BaseMapper<Skill, SkillDto, CreateSkillRequest> {
}
