package com.org.cp.servlet;

import java.io.IOException;
import java.sql.Date;

import com.org.cp.dao.JobDAO;
import com.org.cp.dao.JobDAOImpl;
import com.org.cp.model.Company;
import com.org.cp.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/postJob")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobDAO jobDAO;

    @Override
    public void init() throws ServletException {

        jobDAO = new JobDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null ||
            session.getAttribute("company") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        try {

            Company company =
                    (Company) session.getAttribute(
                            "company");

            String jobTitle =
                    request.getParameter(
                            "jobTitle");

            String description =
                    request.getParameter(
                            "description");

            double requiredCGPA =
                    Double.parseDouble(
                            request.getParameter(
                                    "requiredCGPA"));

            String skills =
                    request.getParameter(
                            "skills");

            Date lastDate =
                    Date.valueOf(
                            request.getParameter(
                                    "lastDate"));

            Job job = new Job();

            job.setCompanyId(
                    company.getCompanyId());

            job.setJobTitle(
                    jobTitle);

            job.setDescription(
                    description);

            job.setRequiredCGPA(
                    requiredCGPA);

            job.setSkills(
                    skills);

            job.setLastDate(
                    lastDate);

            int result =
                    jobDAO.addJob(job);

            if (result > 0) {

                request.setAttribute(
                        "success",
                        "Job Posted Successfully");

                request.getRequestDispatcher(
                        "postJob.jsp")
                        .forward(request,
                                 response);
            }
            else {

                request.setAttribute(
                        "error",
                        "Failed To Post Job");

                request.getRequestDispatcher(
                        "postJob.jsp")
                        .forward(request,
                                 response);
            }

        }
        catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    "Error : "
                    + e.getMessage());

            request.getRequestDispatcher(
                    "postJob.jsp")
                    .forward(request,
                             response);
        }
    }
}