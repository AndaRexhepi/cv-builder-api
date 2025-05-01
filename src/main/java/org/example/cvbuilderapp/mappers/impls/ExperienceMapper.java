package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.experience.CreateExperienceRequest;
import org.example.cvbuilderapp.dtos.experience.ExperienceDto;
import org.example.cvbuilderapp.entities.Experience;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExperienceMapper extends BaseMapper<Experience, ExperienceDto, CreateExperienceRequest> {
}
