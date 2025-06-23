package example.repository;

import example.entities.InterviewResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewResultRepo extends JpaRepository<InterviewResult, Integer> {
}
