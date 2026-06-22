package com.org.cp.model;

import java.sql.Date;

public class Application {

    private int applicationId;
    private int studentId;
    private int jobId;
    private Date appliedDate;
    private String status;

    public Application() {
        super();
    }

    public Application(int applicationId,
                       int studentId,
                       int jobId,
                       Date appliedDate,
                       String status) {

        this.applicationId = applicationId;
        this.studentId = studentId;
        this.jobId = jobId;
        this.appliedDate = appliedDate;
        this.status = status;
    }

    public Application(int studentId,
                       int jobId,
                       Date appliedDate,
                       String status) {

        this.studentId = studentId;
        this.jobId = jobId;
        this.appliedDate = appliedDate;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application [applicationId=" + applicationId
                + ", studentId=" + studentId
                + ", jobId=" + jobId
                + ", appliedDate=" + appliedDate
                + ", status=" + status
                + "]";
    }
}