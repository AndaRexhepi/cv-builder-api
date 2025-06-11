package org.example.cvbuilderapp.repositories;

import org.example.cvbuilderapp.entities.Resume;
import org.example.cvbuilderapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);
    Optional<User> findByEmail(String email);
    Optional<User> findByResumeId(Long resumeId);
}
