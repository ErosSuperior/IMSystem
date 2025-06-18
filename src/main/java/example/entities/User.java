package example.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password_hash;

    @Column(nullable = false, length = 100)
    private String full_name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Boolean status = true;

    @OneToMany(mappedBy = "created_by")
    private List<Job> createdJobs;

    @OneToMany(mappedBy = "created_by")
    private List<Offer> createdOffers;

    @OneToMany(mappedBy = "approved_by")
    private List<Offer> approvedOffers;

    @ManyToMany(mappedBy = "interviewers")
    private List<Interview> interviews;

    // Getters and Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Job> getCreatedJobs() {
        return createdJobs;
    }

    public void setCreatedJobs(List<Job> createdJobs) {
        this.createdJobs = createdJobs;
    }

    public List<Offer> getCreatedOffers() {
        return createdOffers;
    }

    public void setCreatedOffers(List<Offer> createdOffers) {
        this.createdOffers = createdOffers;
    }

    public List<Offer> getApprovedOffers() {
        return approvedOffers;
    }

    public void setApprovedOffers(List<Offer> approvedOffers) {
        this.approvedOffers = approvedOffers;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }
}
