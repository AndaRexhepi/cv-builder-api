package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.pursuit.CreatePursuitRequest;
import org.example.cvbuilderapp.dtos.pursuit.PursuitDto;
import org.example.cvbuilderapp.entities.Pursuit;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PursuitMapper extends BaseMapper<Pursuit, PursuitDto, CreatePursuitRequest> {
//    List<PursuitDto> toDto(List<Pursuit> pursuits);
//
//    PursuitDto toDto(Pursuit pursuit);
//
//    Pursuit toEntity(PursuitDto pursuitDto);
//
//    Pursuit toEntity(CreatePursuitRequest request);

}
