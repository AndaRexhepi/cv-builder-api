package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.objective.CreateObjectiveRequest;
import org.example.cvbuilderapp.dtos.objective.ObjectiveDto;
import org.example.cvbuilderapp.dtos.objective.UpdateObjectiveRequest;
import org.example.cvbuilderapp.exceptions.objective.ObjectiveNotFoundException;
import org.example.cvbuilderapp.mappers.impls.ObjectiveMapper;
import org.example.cvbuilderapp.repositories.ObjectiveRepository;
import org.example.cvbuilderapp.services.interfaces.ObjectiveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectiveServiceImpl implements ObjectiveService {

    public final ObjectiveRepository objectiveRepository;
    public final ObjectiveMapper mapper;


    @Override
    public List<ObjectiveDto> findAll() {
        return mapper.toDto(objectiveRepository.findAll());
    }

    @Override
    public ObjectiveDto findById(Long id) {
        var objectiveFromDb = objectiveRepository.findById(id)
                .orElseThrow(()-> new ObjectiveNotFoundException(id));

        return mapper.toDto(objectiveFromDb);
    }

    @Override
    public ObjectiveDto create(CreateObjectiveRequest objectiveDto) {
        var objectiveFromRequest = mapper.toEntity(objectiveDto);
        objectiveRepository.save(objectiveFromRequest);
        return mapper.toDto(objectiveFromRequest);
    }

    @Override
    public void update(Long id, UpdateObjectiveRequest objectiveDto) {
        var objectiveFromDb = objectiveRepository.findById(id)
                .orElseThrow(()-> new ObjectiveNotFoundException(id));

        objectiveFromDb.setObjective(objectiveDto.getObjective());
        objectiveRepository.save(objectiveFromDb);
    }

    @Override
    public void delete(Long id) {
        var objectiveFromDb = objectiveRepository.findById(id)
                .orElseThrow(()-> new ObjectiveNotFoundException(id));
        objectiveRepository.delete(objectiveFromDb);
    }
}
