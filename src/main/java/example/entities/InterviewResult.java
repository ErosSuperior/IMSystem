package example.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "InterviewResults")
public class InterviewResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int result_id;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    private Integer score;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Passed','Failed','N/A') DEFAULT 'N/A'")
    private Result result = Result.N_A;

    public enum Result {
        Passed, Failed, N_A
    }

    // Getters and Setters
    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
