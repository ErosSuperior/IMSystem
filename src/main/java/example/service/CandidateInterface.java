package example.service;

import example.entities.Candidate;

public interface CandidateInterface {
    Candidate login(String username, String password);
}
