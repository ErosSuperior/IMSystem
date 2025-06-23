package example.dto;

public class InterviewResultDTO {
    private Integer resultId;
    private Integer interviewId;
    private Integer score;
    private String feedback;
    private String result;

    // Getters and Setters
    public Integer getResultId() { return resultId; }
    public void setResultId(Integer resultId) { this.resultId = resultId; }
    public Integer getInterviewId() { return interviewId; }
    public void setInterviewId(Integer interviewId) { this.interviewId = interviewId; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
} 