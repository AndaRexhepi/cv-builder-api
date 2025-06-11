package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByResumeId(Long id);
}
