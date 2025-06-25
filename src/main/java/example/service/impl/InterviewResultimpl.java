package example.service.impl;

import example.entities.InterviewResult;
import example.repository.InterviewResultRepo;
import example.service.InterviewResultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InterviewResultimpl implements InterviewResultInterface {
    @Autowired
    private InterviewResultRepo repository;
    @Override
    public List<InterviewResult> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<InterviewResult> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public InterviewResult save(InterviewResult interviewResult) {
        return repository.save(interviewResult);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
