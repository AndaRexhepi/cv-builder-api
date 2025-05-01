package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.pursuit.CreatePursuitRequest;
import org.example.cvbuilderapp.dtos.pursuit.PursuitDto;
import org.example.cvbuilderapp.dtos.pursuit.UpdatePursuitRequest;
import org.example.cvbuilderapp.exceptions.pursuit.PursuitNotFoundException;
import org.example.cvbuilderapp.mappers.impls.PursuitMapper;
import org.example.cvbuilderapp.repositories.PursuitRepository;
import org.example.cvbuilderapp.services.interfaces.PursuitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PursuitServiceImpl implements PursuitService {

    public final PursuitRepository pursuitRepository;
    public final PursuitMapper mapper;

    @Override
    public List<PursuitDto> findAll() {
        return mapper.toDto(pursuitRepository.findAll());
    }

    @Override
    public PursuitDto findById(Long id) {
        var pursuitFromDb = pursuitRepository.findById(id)
                .orElseThrow(()-> new PursuitNotFoundException(id));
        return mapper.toDto(pursuitFromDb);
    }

    @Override
    public PursuitDto create(CreatePursuitRequest request) {
        var pursuitFromRequest = mapper.toEntity(request);
        pursuitRepository.save(pursuitFromRequest);
        return mapper.toDto(pursuitFromRequest);
    }

    @Override
    public void update(Long id, UpdatePursuitRequest request) {
        var pursuitFromDb = pursuitRepository.findById(id)
                .orElseThrow(()-> new PursuitNotFoundException(id));

        pursuitFromDb.setPursuit(request.getPursuit());

        pursuitRepository.save(pursuitFromDb);
    }

    @Override
    public void delete(Long id) {
        var pursuitFromDb = pursuitRepository.findById(id)
                .orElseThrow(()-> new PursuitNotFoundException(id));
        pursuitRepository.delete(pursuitFromDb);
    }
}
