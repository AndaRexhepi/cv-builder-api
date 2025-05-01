package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.dtos.profile.ProfileDto;
import org.example.cvbuilderapp.dtos.profile.UpdateProfileRequest;
import org.example.cvbuilderapp.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
