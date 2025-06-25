package example.service.impl;

import example.entities.Candidate;
import example.repository.CandidateRepo;
import example.service.CandidateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class Candidateimpl implements CandidateInterface {
    @Autowired
    private CandidateRepo candidateRepositoryRepo;

    public CandidateRepo getCandidateRepositoryRepo() {
        return candidateRepositoryRepo;
    }

    public void setCandidateRepositoryRepo(CandidateRepo candidateRepositoryRepo) {
        this.candidateRepositoryRepo = candidateRepositoryRepo;
    }

    @Override
    public Candidate login(String username, String password) {
        Optional<Candidate> candidate = candidateRepositoryRepo.findByUsername(username);
        if (candidate.isPresent() && candidate.get().getPassword_hash().equals(password)) {
            return candidate.get();
        }
        return null;
    }
}
