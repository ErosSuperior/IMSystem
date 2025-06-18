package example.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Interviews")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interview_id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private Date schedule_time;
    private Date end_time;

    @Enumerated(EnumType.STRING)
    private Status status = Status.Scheduled;

    @Column(columnDefinition = "TEXT")
    private String note;

    @OneToMany(mappedBy = "interview")
    private List<InterviewResult> results;

    @ManyToMany
    @JoinTable(
            name = "Interviewers",
            joinColumns = @JoinColumn(name = "interview_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> interviewers;

    @OneToMany(mappedBy = "interview")
    private List<Offer> offers;

    public enum Status {
        Scheduled, Cancelled, Completed
    }

    // Getters and Setters
    public int getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(int interview_id) {
        this.interview_id = interview_id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date getSchedule_time() {
        return schedule_time;
    }

    public void setSchedule_time(Date schedule_time) {
        this.schedule_time = schedule_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<InterviewResult> getResults() {
        return results;
    }

    public void setResults(List<InterviewResult> results) {
        this.results = results;
    }

    public List<User> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<User> interviewers) {
        this.interviewers = interviewers;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
