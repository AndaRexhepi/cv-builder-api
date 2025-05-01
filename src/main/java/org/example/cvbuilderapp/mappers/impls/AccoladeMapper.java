package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.accolade.AccoladeDto;
import org.example.cvbuilderapp.dtos.accolade.CreateAccoladeRequest;
import org.example.cvbuilderapp.entities.Accolade;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccoladeMapper extends BaseMapper<Accolade, AccoladeDto, CreateAccoladeRequest> {

}
