package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
    Optional<Objective> findByResumeId(Long resumeId);
}
