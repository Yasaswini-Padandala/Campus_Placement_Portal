package com.org.cp.model;


import java.sql.Date;

public class Job {

    private int jobId;
    private int companyId;
    private String jobTitle;
    private String description;
    private double requiredCGPA;
    private String skills;
    private Date lastDate;

    public Job() {
        super();
    }

    public Job(int jobId, int companyId, String jobTitle,
               String description, double requiredCGPA,
               String skills, Date lastDate) {

        this.jobId = jobId;
        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.description = description;
        this.requiredCGPA = requiredCGPA;
        this.skills = skills;
        this.lastDate = lastDate;
    }

    public Job(int companyId, String jobTitle,
               String description, double requiredCGPA,
               String skills, Date lastDate) {

        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.description = description;
        this.requiredCGPA = requiredCGPA;
        this.skills = skills;
        this.lastDate = lastDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRequiredCGPA() {
        return requiredCGPA;
    }

    public void setRequiredCGPA(double requiredCGPA) {
        this.requiredCGPA = requiredCGPA;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "Job [jobId=" + jobId
                + ", companyId=" + companyId
                + ", jobTitle=" + jobTitle
                + ", description=" + description
                + ", requiredCGPA=" + requiredCGPA
                + ", skills=" + skills
                + ", lastDate=" + lastDate
                + "]";
    }
}