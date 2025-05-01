package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.profile.CreateProfileRequest;
import org.example.cvbuilderapp.dtos.profile.ProfileDto;
import org.example.cvbuilderapp.entities.Profile;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileMapper extends BaseMapper<Profile, ProfileDto, CreateProfileRequest> {


}
