package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.accolade.AccoladeDto;
import org.example.cvbuilderapp.dtos.accolade.CreateAccoladeRequest;
import org.example.cvbuilderapp.dtos.accolade.UpdateAccoladeRequest;
import org.example.cvbuilderapp.exceptions.accolade.AccoladeNotFoundException;
import org.example.cvbuilderapp.mappers.impls.AccoladeMapper;
import org.example.cvbuilderapp.repositories.AccoladeRepository;
import org.example.cvbuilderapp.services.interfaces.AccoladeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccoladeServiceImpl implements AccoladeService {

    public final AccoladeRepository accoladeRepository;
    public final AccoladeMapper mapper;

    @Override
    public List<AccoladeDto> findAll() {
        return mapper.toDto(accoladeRepository.findAll());
    }

    @Override
    public AccoladeDto findById(Long id) {
        var accoladeFromDb = accoladeRepository.findById(id)
                .orElseThrow(()-> new AccoladeNotFoundException(id));

        return mapper.toDto(accoladeFromDb);
    }

    @Override
    public AccoladeDto create(CreateAccoladeRequest request) {
        var accoladeFromRequest = mapper.toEntity(request);
        accoladeRepository.save(accoladeFromRequest);
        return mapper.toDto(accoladeFromRequest);
    }

    @Override
    public void update(Long id, UpdateAccoladeRequest request) {
       var accoladeFromDb = accoladeRepository.findById(id)
                .orElseThrow( ()-> new AccoladeNotFoundException(id));

        accoladeFromDb.setAccolade(request.getAccolade());
        accoladeFromDb.setOrganization(request.getOrganization());
        accoladeFromDb.setDescription(request.getDescription());
        accoladeFromDb.setIssueDate(request.getIssueDate());
        accoladeFromDb.setResume(request.getResume());

        accoladeRepository.save(accoladeFromDb);
    }

    @Override
    public void delete(Long id) {
        var accoladeFromDb = accoladeRepository.findById(id)
                .orElseThrow(()-> new AccoladeNotFoundException(id));
        accoladeRepository.delete(accoladeFromDb);
    }

    @Override
    public Optional<AccoladeDto> findByResumeId(Long resumeId) {
        return accoladeRepository.findByResumeId(resumeId).map(mapper::toDto);
    }
}
