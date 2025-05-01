package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.education.CreateEducationRequest;
import org.example.cvbuilderapp.dtos.education.EducationDto;
import org.example.cvbuilderapp.entities.Education;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EducationMapper extends BaseMapper<Education, EducationDto, CreateEducationRequest> {

}
