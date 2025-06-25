package example.repository;

import example.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    Optional<Candidate> findByUsername(String username);
}
