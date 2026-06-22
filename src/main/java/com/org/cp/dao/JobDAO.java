package com.org.cp.dao;

import java.util.List;

import com.org.cp.model.Job;

public interface JobDAO {

    int addJob(Job job);

    Job getJobById(int jobId);

    List<Job> getAllJobs();

    List<Job> getJobsByCompanyId(int companyId);

    int updateJob(Job job);

    int deleteJob(int jobId);
}