package org.example.cvbuilderapp.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.profile.CreateProfileRequest;
import org.example.cvbuilderapp.dtos.profile.ProfileDto;
import org.example.cvbuilderapp.dtos.profile.UpdateProfileRequest;
import org.example.cvbuilderapp.exceptions.profile.ProfileNotFoundException;
import org.example.cvbuilderapp.mappers.impls.ProfileMapper;
import org.example.cvbuilderapp.repositories.ProfileRepository;
import org.example.cvbuilderapp.services.interfaces.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    public final ProfileRepository profileRepository;
    public final ProfileMapper mapper;

    @Override
    public List<ProfileDto> findAll() {
        return mapper.toDto(profileRepository.findAll());
    }

    @Override
    public ProfileDto findById(Long id) {
        var profileFromDb = profileRepository.findById(id)
                .orElseThrow(()-> new ProfileNotFoundException(id));
        return mapper.toDto(profileFromDb);
    }


    @Override
    public ProfileDto create(CreateProfileRequest request) {
        var profileFromRequest = mapper.toEntity(request);
        profileRepository.save(profileFromRequest);
        return mapper.toDto(profileFromRequest);
    }

    @Override
    public void update(Long id, UpdateProfileRequest request) {
        var profileFromDb = profileRepository.findById(id)
                .orElseThrow(()-> new ProfileNotFoundException(id));

        profileFromDb.setProfileImage(request.getProfileImage());
        profileFromDb.setFirstName(request.getFirstName());
        profileFromDb.setLastName(request.getLastName());
        profileFromDb.setPhoneNumber(request.getPhoneNumber());
        profileFromDb.setEmail(request.getEmail());
        profileFromDb.setAddress(request.getAddress());
        profileFromDb.setCity(request.getCity());
        profileFromDb.setCountry(request.getCountry());
        profileFromDb.setZipCode(request.getZipCode());

        profileRepository.save(profileFromDb);
    }

    @Override
    public void delete(Long id) {
        var profileFromDb = profileRepository.findById(id)
                .orElseThrow(()-> new ProfileNotFoundException(id));
        profileRepository.delete(profileFromDb);
    }

    @Override
    public Optional<ProfileDto> findByResumeId(Long resumeId) {
        return profileRepository.findByResumeId(resumeId).map(mapper::toDto);
    }
}
