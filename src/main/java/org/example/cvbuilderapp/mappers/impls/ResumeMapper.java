package org.example.cvbuilderapp.mappers.impls;

import org.example.cvbuilderapp.dtos.resume.CreateResumeRequest;
import org.example.cvbuilderapp.dtos.resume.ResumeDto;
import org.example.cvbuilderapp.entities.Resume;
import org.example.cvbuilderapp.entities.User;
import org.example.cvbuilderapp.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResumeMapper extends BaseMapper<Resume, ResumeDto, CreateResumeRequest> {

    @Mapping(target = "user", source = "userId")
    Resume toEntity(CreateResumeRequest request);

    default User map(Long id) {
        if (id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }

    ResumeDto toDto(Resume resume);
}
