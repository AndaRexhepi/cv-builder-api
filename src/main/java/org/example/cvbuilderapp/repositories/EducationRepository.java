package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    Optional<Education> findByResumeId(Long resumeId);
}
