package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.skill.CreateSkillRequest;
import org.example.cvbuilderapp.dtos.skill.SkillDto;
import org.example.cvbuilderapp.dtos.skill.UpdateSkillRequest;
import org.example.cvbuilderapp.entities.Skill;
import org.example.cvbuilderapp.exceptions.skill.SkillNotFoundException;
import org.example.cvbuilderapp.mappers.impls.SkillMapper;
import org.example.cvbuilderapp.repositories.SkillRepository;
import org.example.cvbuilderapp.services.interfaces.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    public final SkillRepository skillRepository;
    public final SkillMapper mapper;


    @Override
    public List<SkillDto> findAll() {
        return mapper.toDto(skillRepository.findAll());
    }

    @Override
    public SkillDto findById(Long id) {
        var skillFromDB = skillRepository.findById(id)
                .orElseThrow(()-> new SkillNotFoundException(id));

        return mapper.toDto(skillFromDB);
    }

    @Override
    public SkillDto create(CreateSkillRequest request) {
        var skillFromRequest = mapper.toEntity(request);
        skillRepository.save(skillFromRequest);
        return mapper.toDto(skillFromRequest);
    }

    @Override
    public void update(Long id, UpdateSkillRequest request) {
        var skillFromDb = skillRepository.findById(id)
                .orElseThrow(()-> new SkillNotFoundException(id));

        skillFromDb.setSkill(request.getSkill());

        skillRepository.save(skillFromDb);
    }

    @Override
    public void delete(Long id) {
        var skillFromDb = skillRepository.findById(id)
                .orElseThrow(()-> new SkillNotFoundException(id));
        skillRepository.delete(skillFromDb);
    }

    @Override
    public Optional<SkillDto> findByResumeId(Long resumeId) {
        return skillRepository.findByResumeId(resumeId).map(mapper::toDto);
    }
}
