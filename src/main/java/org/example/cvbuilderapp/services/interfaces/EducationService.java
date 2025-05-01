package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.education.CreateEducationRequest;
import org.example.cvbuilderapp.dtos.education.EducationDto;
import org.example.cvbuilderapp.dtos.education.UpdateEducationRequest;

public interface EducationService extends BaseService<EducationDto, CreateEducationRequest, UpdateEducationRequest, Long> {
}
