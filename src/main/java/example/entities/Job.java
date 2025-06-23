package example.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int job_id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String skills;

    private Date start_date;
    private Date end_date;
    private Integer salary_from;
    private Integer salary_to;
    
    @Column(length = 255)
    private String address;

    @Column(columnDefinition = "TEXT")
    private String benefits;

    @Column(length = 100)
    private String levels;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Draft', 'Open', 'Closed') DEFAULT 'Draft'")
    private Status status = Status.Draft;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User created_by;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;

    @OneToMany(mappedBy = "job")
    private List<JobApplication> applications;

    @OneToMany(mappedBy = "job")
    private List<Interview> interviews;

    public enum Status {
        Draft, Open, Closed
    }

    // Getters and Setters
    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getSalary_from() {
        return salary_from;
    }

    public void setSalary_from(Integer salary_from) {
        this.salary_from = salary_from;
    }

    public Integer getSalary_to() {
        return salary_to;
    }

    public void setSalary_to(Integer salary_to) {
        this.salary_to = salary_to;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<JobApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<JobApplication> applications) {
        this.applications = applications;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }
}
