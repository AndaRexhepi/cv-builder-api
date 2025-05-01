package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.objective.CreateObjectiveRequest;
import org.example.cvbuilderapp.dtos.objective.ObjectiveDto;
import org.example.cvbuilderapp.entities.Objective;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ObjectiveMapper extends BaseMapper<Objective, ObjectiveDto, CreateObjectiveRequest> {
}
