package com.org.cp.dao;

import java.util.List;
import com.org.cp.model.Application;

public interface ApplicationDAO {

    int addApplication(Application application);

    Application getApplicationById(int applicationId);

    List<Application> getAllApplications();

    List<Application> getApplicationsByStudentId(int studentId);

    List<Application> getApplicationsByJobId(int jobId);

    int updateStatus(int applicationId,
                     String status);

    int deleteApplication(int applicationId);

	List<Application> getApplicationsByCompanyId(int companyId);

	int updateApplicationStatus(int applicationId, String status);
}