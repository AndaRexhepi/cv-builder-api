package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Pursuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PursuitRepository extends JpaRepository<Pursuit, Long> {
}
