package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cvbuilderapp.dtos.user.CreateUserRequest;
import org.example.cvbuilderapp.dtos.user.UpdateUserRequest;
import org.example.cvbuilderapp.dtos.user.UserDto;
import org.example.cvbuilderapp.entities.User;
import org.example.cvbuilderapp.exceptions.user.UserAlreadyExistsException;
import org.example.cvbuilderapp.exceptions.user.UserNotFoundException;
import org.example.cvbuilderapp.mappers.impls.UserMapper;
import org.example.cvbuilderapp.repositories.UserRepository;
import org.example.cvbuilderapp.services.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final UserMapper mapper;
    public final PasswordEncoder passwordEncoder;

    @Override
    public UserDto findById(Long id) {
        var userFromDb = userRepository.findById(id);
        if (userFromDb.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        return mapper.toDto(userFromDb.get());
//        return userFromDb.map(mapper::toDto).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public UserDto create(CreateUserRequest userDto) {
        var userFromRequest = mapper.toEntity(userDto);
        if (userRepository.existsUserByEmail(userFromRequest.getEmail())) {
            throw new UserAlreadyExistsException(userFromRequest.getEmail());
        }
        userFromRequest.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return mapper.toDto(userRepository.save(userFromRequest));
    }

    @Override
    public void update(Long id, UpdateUserRequest userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // 2. Check for email uniqueness if email is being changed
        if (!existingUser.getEmail().equals(userDto.getEmail())) {
            if (userRepository.existsUserByEmail(userDto.getEmail())) {
                throw new UserAlreadyExistsException(userDto.getEmail());
            }
        }

        // 3. Update the managed entity directly
        existingUser.setName(userDto.getName());
        existingUser.setSurname(userDto.getSurname());
        existingUser.setEmail(userDto.getEmail());

        userRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) {
        var userFromDb = userRepository.findById(id);
        if (userFromDb.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        userRepository.delete(userFromDb.get());
    }

    @Override
    public List<UserDto> findAll() {
        return mapper.toDto(userRepository.findAll());
    }
}
