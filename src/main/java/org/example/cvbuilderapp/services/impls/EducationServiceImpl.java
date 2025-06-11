package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.education.CreateEducationRequest;
import org.example.cvbuilderapp.dtos.education.EducationDto;
import org.example.cvbuilderapp.dtos.education.UpdateEducationRequest;
import org.example.cvbuilderapp.exceptions.education.EducationNotFoundException;
import org.example.cvbuilderapp.mappers.impls.EducationMapper;
import org.example.cvbuilderapp.repositories.EducationRepository;
import org.example.cvbuilderapp.services.interfaces.EducationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    public final EducationRepository educationRepository;
    public final EducationMapper mapper;

    @Override
    public List<EducationDto> findAll() {
        return mapper.toDto(educationRepository.findAll());
    }

    @Override
    public EducationDto findById(Long id) {
        var educationFromDb = educationRepository.findById(id)
                .orElseThrow(()-> new EducationNotFoundException(id));

        return mapper.toDto(educationFromDb);
    }

    @Override
    public EducationDto create(CreateEducationRequest request) {
        var educationFromRequest = mapper.toEntity(request);
        educationRepository.save(educationFromRequest);
        return mapper.toDto(educationFromRequest);
    }

    @Override
    public void update(Long id, UpdateEducationRequest request) {
        var educationFromDb = educationRepository.findById(id)
                .orElseThrow(()-> new EducationNotFoundException(id));

        educationFromDb.setDegree(request.getDegree());
        educationFromDb.setSchool(request.getSchool());
        educationFromDb.setGpa(request.getGpa());
        educationFromDb.setStartDate(request.getStartDate());
        educationFromDb.setEndDate(request.getEndDate());
        educationFromDb.setDescription(request.getDescription());
        educationFromDb.setIsPresent(request.getIsPresent());

        educationRepository.save(educationFromDb);
    }

    @Override
    public void delete(Long id) {
        var educationFromDb = educationRepository.findById(id)
                .orElseThrow(()-> new EducationNotFoundException(id));
        educationRepository.delete(educationFromDb);
    }

    @Override
    public Optional<EducationDto> findByResumeId(Long resumeId) {
        return educationRepository.findByResumeId(resumeId).map(mapper::toDto);
    }
}
