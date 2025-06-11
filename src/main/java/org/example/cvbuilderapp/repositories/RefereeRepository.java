package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Referee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefereeRepository extends JpaRepository<Referee, Long> {
    Optional<Referee> findByResumeId(Long resumeId);
}
