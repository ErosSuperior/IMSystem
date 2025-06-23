package example.dto;

public class JobDTO {
    private Integer jobId;
    private String title;
    private String skills;
    private String status;
    private String levels;
    private String address;
    private String description;
    private Integer salaryFrom;
    private Integer salaryTo;

    // Getters and Setters
    public Integer getJobId() { return jobId; }
    public void setJobId(Integer jobId) { this.jobId = jobId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getLevels() { return levels; }
    public void setLevels(String levels) { this.levels = levels; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getSalaryFrom() { return salaryFrom; }
    public void setSalaryFrom(Integer salaryFrom) { this.salaryFrom = salaryFrom; }
    public Integer getSalaryTo() { return salaryTo; }
    public void setSalaryTo(Integer salaryTo) { this.salaryTo = salaryTo; }
} 