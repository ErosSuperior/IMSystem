package example.service;

import example.entities.InterviewResult;

import java.util.List;
import java.util.Optional;

public interface InterviewResultInterface {
    List<InterviewResult> findAll();
    Optional<InterviewResult> findById(int id);
    InterviewResult save(InterviewResult interviewResult);
    void deleteById(int id);
}
