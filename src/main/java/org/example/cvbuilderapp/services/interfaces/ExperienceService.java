package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.experience.CreateExperienceRequest;
import org.example.cvbuilderapp.dtos.experience.ExperienceDto;
import org.example.cvbuilderapp.dtos.experience.UpdateExperienceRequest;

public interface ExperienceService extends BaseService<ExperienceDto, CreateExperienceRequest, UpdateExperienceRequest, Long> {

}
