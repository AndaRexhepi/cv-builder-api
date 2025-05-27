package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.referee.CreateRefereeRequest;
import org.example.cvbuilderapp.dtos.referee.RefereeDto;
import org.example.cvbuilderapp.dtos.referee.UpdateRefereeRequest;
import org.example.cvbuilderapp.exceptions.referee.RefereeNotFoundException;
import org.example.cvbuilderapp.mappers.impls.RefereeMapper;
import org.example.cvbuilderapp.repositories.RefereeRepository;
import org.example.cvbuilderapp.services.interfaces.RefereeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefereeServiceImpl implements RefereeService {

    public final RefereeRepository refereeRepository;
    public final RefereeMapper mapper;

    @Override
    public List<RefereeDto> findAll() {
        return mapper.toDto(refereeRepository.findAll());
    }

    @Override
    public RefereeDto findById(Long id) {
        var refereeFromDb = refereeRepository.findById(id)
                .orElseThrow(()-> new RefereeNotFoundException(id));
        return mapper.toDto(refereeFromDb);
    }

    @Override
    public RefereeDto create(CreateRefereeRequest request) {
        var refereeFromRequest = mapper.toEntity(request);
        refereeRepository.save(refereeFromRequest);
        return mapper.toDto(refereeFromRequest);
    }

    @Override
    public void update(Long id, UpdateRefereeRequest request) {
        var refereeFromDb = refereeRepository.findById(id)
                .orElseThrow(()-> new RefereeNotFoundException(id));

        refereeFromDb.setFullName(request.getFullName());
        refereeFromDb.setDescription(request.getDescription());
        refereeFromDb.setRelationship(request.getRelationship());
        refereeFromDb.setJobTitle(request.getJobTitle());

        refereeRepository.save(refereeFromDb);
    }

    @Override
    public void delete(Long id) {
        var refereeFromDb = refereeRepository.findById(id)
                .orElseThrow(()-> new RefereeNotFoundException(id));
        refereeRepository.delete(refereeFromDb);
    }
}
