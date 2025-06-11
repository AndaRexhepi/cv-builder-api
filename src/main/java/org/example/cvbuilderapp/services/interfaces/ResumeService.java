package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.resume.CreateResumeRequest;
import org.example.cvbuilderapp.dtos.resume.ResumeDto;
import org.example.cvbuilderapp.dtos.resume.UpdateResumeRequest;

import java.util.List;
import java.util.Optional;

public interface ResumeService extends BaseService<ResumeDto, CreateResumeRequest, UpdateResumeRequest, Long>{
    Optional<List<ResumeDto>> findByUserId(Long userId);
}
