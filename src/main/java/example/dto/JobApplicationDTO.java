package example.dto;

public class JobApplicationDTO {
    private Integer applicationId;
    private Integer candidateId;
    private Integer jobId;
    private String status;
    private String applyDate;
    private String note;

    // Getters and Setters
    public Integer getApplicationId() { return applicationId; }
    public void setApplicationId(Integer applicationId) { this.applicationId = applicationId; }
    public Integer getCandidateId() { return candidateId; }
    public void setCandidateId(Integer candidateId) { this.candidateId = candidateId; }
    public Integer getJobId() { return jobId; }
    public void setJobId(Integer jobId) { this.jobId = jobId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getApplyDate() { return applyDate; }
    public void setApplyDate(String applyDate) { this.applyDate = applyDate; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
} 