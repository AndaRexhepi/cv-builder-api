package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Accolade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccoladeRepository extends JpaRepository<Accolade, Long> {
}
