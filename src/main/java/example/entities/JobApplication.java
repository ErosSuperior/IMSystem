package example.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "JobApplications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int application_id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date apply_date;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Applied', 'Under Review', 'Rejected', 'Accepted') DEFAULT 'Applied'")
    private Status status = Status.Applied;

    @Column(length = 255)
    private String cv_path;

    @Column(columnDefinition = "TEXT")
    private String note;

    public enum Status {
        Applied, 
        Under_Review("Under Review"), 
        Rejected, 
        Accepted;
        
        private final String value;
        
        Status() {
            this.value = this.name();
        }
        
        Status(String value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value;
        }
    }

    // Getters and Setters
    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
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

    public Date getApply_date() {
        return apply_date;
    }

    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCv_path() {
        return cv_path;
    }

    public void setCv_path(String cv_path) {
        this.cv_path = cv_path;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
