package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.user.CreateUserRequest;
import org.example.cvbuilderapp.dtos.user.UserDto;
import org.example.cvbuilderapp.entities.Resume;
import org.example.cvbuilderapp.entities.User;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserDto, CreateUserRequest> {


    @Mapping(target = "resumeIds", expression = "java(mapResumeIds(user.getResume()))")
    UserDto toDto(User user);

    default List<Long> mapResumeIds(List<Resume> resumes) {
        return resumes.stream()
                .map(Resume::getId)
                .collect(Collectors.toList());
    }
}