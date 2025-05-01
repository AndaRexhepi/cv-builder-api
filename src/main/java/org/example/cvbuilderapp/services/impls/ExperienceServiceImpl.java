package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.experience.CreateExperienceRequest;
import org.example.cvbuilderapp.dtos.experience.ExperienceDto;
import org.example.cvbuilderapp.dtos.experience.UpdateExperienceRequest;
import org.example.cvbuilderapp.exceptions.experience.ExperienceNotFoundException;
import org.example.cvbuilderapp.mappers.impls.ExperienceMapper;
import org.example.cvbuilderapp.repositories.ExperienceRepository;
import org.example.cvbuilderapp.services.interfaces.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    public final ExperienceRepository experienceRepository;
    public final ExperienceMapper mapper;

    @Override
    public List<ExperienceDto> findAll() {
        return mapper.toDto(experienceRepository.findAll());
    }

    @Override
    public ExperienceDto findById(Long id) {
        var experienceFromDb = experienceRepository.findById(id)
                .orElseThrow(()-> new ExperienceNotFoundException(id));
        return mapper.toDto(experienceFromDb);
    }

    @Override
    public ExperienceDto create(CreateExperienceRequest experienceDto) {
        var experienceFromRequest = mapper.toEntity(experienceDto);
        experienceRepository.save(experienceFromRequest);
        return mapper.toDto(experienceFromRequest);
    }

    @Override
    public void update(Long id, UpdateExperienceRequest experienceDto) {
        var experienceFromDb = experienceRepository.findById(id)
                .orElseThrow(()-> new ExperienceNotFoundException(id));

        experienceFromDb.setCompany(experienceDto.getCompany());
        experienceFromDb.setStartDate(experienceDto.getStartDate());
        experienceFromDb.setEndDate(experienceDto.getEndDate());
        experienceFromDb.setDescription(experienceDto.getDescription());
        experienceFromDb.setEmploymentType(experienceDto.getEmploymentType());
        experienceFromDb.setLocation(experienceDto.getLocation());
        experienceFromDb.setPresent(experienceDto.getIsPresent());

        experienceRepository.save(experienceFromDb);
    }

    @Override
    public void delete(Long id) {
        var experienceFromDb = experienceRepository.findById(id)
                .orElseThrow(()-> new ExperienceNotFoundException(id));
        experienceRepository.delete(experienceFromDb);
    }
}
