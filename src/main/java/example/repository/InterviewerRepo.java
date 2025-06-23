package example.repository;

import example.entities.Interviewer;
import example.entities.Interviewer.InterviewerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewerRepo extends JpaRepository<Interviewer, InterviewerId> {
} 