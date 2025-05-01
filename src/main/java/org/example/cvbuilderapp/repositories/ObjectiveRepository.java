package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
}
