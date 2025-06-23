package example.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidate_id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password_hash;

    @Column(nullable = false, length = 100)
    private String full_name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 255)
    private String address;
    
    @Column(length = 100)
    private String current_position;

    @Column(columnDefinition = "TEXT")
    private String skills;

    private Integer years_experience;
    
    @Column(length = 100)
    private String highest_level;
    
    @Column(length = 255)
    private String cv_file_path;
    
    @Column(length = 50)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean self_registered = false;

    @OneToMany(mappedBy = "candidate")
    private List<JobApplication> applications;

    @OneToMany(mappedBy = "candidate")
    private List<Interview> interviews;

    // Getters and Setters
    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrent_position() {
        return current_position;
    }

    public void setCurrent_position(String current_position) {
        this.current_position = current_position;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getYears_experience() {
        return years_experience;
    }

    public void setYears_experience(Integer years_experience) {
        this.years_experience = years_experience;
    }

    public String getHighest_level() {
        return highest_level;
    }

    public void setHighest_level(String highest_level) {
        this.highest_level = highest_level;
    }

    public String getCv_file_path() {
        return cv_file_path;
    }

    public void setCv_file_path(String cv_file_path) {
        this.cv_file_path = cv_file_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getSelf_registered() {
        return self_registered;
    }

    public void setSelf_registered(Boolean self_registered) {
        this.self_registered = self_registered;
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

    public enum Gender {
        Male, Female, Other
    }
}
