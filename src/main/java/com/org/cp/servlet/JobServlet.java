package com.org.cp.servlet;

import java.io.IOException;
import java.util.List;

import com.org.cp.dao.JobDAO;
import com.org.cp.dao.JobDAOImpl;
import com.org.cp.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/job")
public class JobServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	private JobDAO jobDAO;

    @Override
    public void init() throws ServletException {

        jobDAO = new JobDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        if (action == null) {

            action = "viewAllJobs";
        }

        switch (action) {

        case "viewAllJobs":

            viewAllJobs(request, response);
            break;

        default:

            viewAllJobs(request, response);
            break;
        }
    }

    private void viewAllJobs(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            List<Job> jobs =
                    jobDAO.getAllJobs();

            request.setAttribute(
                    "jobs",
                    jobs);

            request.getRequestDispatcher(
                    "viewAllJobs.jsp")
                    .forward(request,
                             response);

        }
        catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    "Unable to fetch jobs");

            request.getRequestDispatcher(
                    "studentDashboard.jsp")
                    .forward(request,
                             response);
        }
    }
}