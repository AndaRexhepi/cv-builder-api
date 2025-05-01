package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.user.CreateUserRequest;
import org.example.cvbuilderapp.dtos.user.UpdateUserRequest;
import org.example.cvbuilderapp.dtos.user.UserDto;

public interface UserService extends BaseService<UserDto, CreateUserRequest, UpdateUserRequest, Long> {

}
