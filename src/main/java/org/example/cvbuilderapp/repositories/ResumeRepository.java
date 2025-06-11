package org.example.cvbuilderapp.repositories;

import jakarta.transaction.Transactional;
import org.example.cvbuilderapp.entities.Resume;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM resumes r WHERE r.user.id = :userId")
    void deleteByUserId(Long userId);

    Optional<List<Resume>> findByUserId(Long userId);
}
