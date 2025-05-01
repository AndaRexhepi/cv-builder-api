package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.user.CreateUserRequest;
import org.example.cvbuilderapp.dtos.user.UserDto;
import org.example.cvbuilderapp.entities.User;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserDto, CreateUserRequest> {

}
