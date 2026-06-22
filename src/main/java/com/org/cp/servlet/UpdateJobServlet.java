package com.org.cp.servlet;

import java.io.IOException;
import java.sql.Date;

import com.org.cp.dao.JobDAO;
import com.org.cp.dao.JobDAOImpl;
import com.org.cp.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateJob")
public class UpdateJobServlet extends HttpServlet {

    private JobDAO jobDAO;

    @Override
    public void init() {

        jobDAO = new JobDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Job job = new Job();

        job.setJobId(
                Integer.parseInt(
                        request.getParameter("jobId")));

        job.setJobTitle(
                request.getParameter("jobTitle"));

        job.setDescription(
                request.getParameter("description"));

        job.setRequiredCGPA(
                Double.parseDouble(
                        request.getParameter("requiredCGPA")));

        job.setSkills(
                request.getParameter("skills"));

        job.setLastDate(
                Date.valueOf(
                        request.getParameter("lastDate")));

        jobDAO.updateJob(job);

        response.sendRedirect(
                "viewCompanyJobs");
    }
}