package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.referee.CreateRefereeRequest;
import org.example.cvbuilderapp.dtos.referee.RefereeDto;
import org.example.cvbuilderapp.entities.Referee;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RefereeMapper extends BaseMapper<Referee, RefereeDto, CreateRefereeRequest> {
}
