package example.dto;

public class OfferDTO {
    private Integer offerId;
    private Integer interviewId;
    private String status;
    private String note;
    private String createdAt;
    private String approvedAt;
    private String responseDate;

    // Getters and Setters
    public Integer getOfferId() { return offerId; }
    public void setOfferId(Integer offerId) { this.offerId = offerId; }
    public Integer getInterviewId() { return interviewId; }
    public void setInterviewId(Integer interviewId) { this.interviewId = interviewId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getApprovedAt() { return approvedAt; }
    public void setApprovedAt(String approvedAt) { this.approvedAt = approvedAt; }
    public String getResponseDate() { return responseDate; }
    public void setResponseDate(String responseDate) { this.responseDate = responseDate; }
} 