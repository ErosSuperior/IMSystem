package example.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offer_id;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User created_by;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private User approved_by;

    private Date created_at;
    private Date approved_at;

    @Enumerated(EnumType.STRING)
    private Status status = Status.WaitingForApproval;

    private Date response_date;

    @Column(columnDefinition = "TEXT")
    private String note;

    public enum Status {
        WaitingForApproval,
        Approved,
        Rejected,
        WaitingForResponse,
        Accepted,
        Declined,
        Cancelled
    }

    // Getters and Setters
    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public User getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(User approved_by) {
        this.approved_by = approved_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getApproved_at() {
        return approved_at;
    }

    public void setApproved_at(Date approved_at) {
        this.approved_at = approved_at;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getResponse_date() {
        return response_date;
    }

    public void setResponse_date(Date response_date) {
        this.response_date = response_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
