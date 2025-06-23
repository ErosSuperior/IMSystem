package example.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Interviewers")
public class Interviewer {

    @EmbeddedId
    private InterviewerId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("interviewId")
    @JoinColumn(name = "interview_id")
    private Interview interview;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public Interviewer() {
    }

    public InterviewerId getId() {
        return id;
    }

    public void setId(InterviewerId id) {
        this.id = id;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Embeddable
    public static class InterviewerId implements Serializable {

        private static final long serialVersionUID = -8298363368249492349L;

        @Column(name = "interview_id")
        private int interviewId;

        @Column(name = "user_id")
        private int userId;

        public InterviewerId() {
        }

        public InterviewerId(int interviewId, int userId) {
            this.interviewId = interviewId;
            this.userId = userId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InterviewerId that = (InterviewerId) o;
            return interviewId == that.interviewId && userId == that.userId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(interviewId, userId);
        }
    }
} 