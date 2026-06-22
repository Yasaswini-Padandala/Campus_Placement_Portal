package com.org.cp.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/viewCompanyJobs")
public class ViewCompanyJobsServlet extends HttpServlet {

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

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("company") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        try {

            Company company =
                    (Company) session.getAttribute("company");

            List<Job> jobs =
                    jobDAO.getJobsByCompanyId(
                            company.getCompanyId());

            request.setAttribute("jobs", jobs);

            request.getRequestDispatcher(
                    "viewCompanyJobs.jsp")
                    .forward(request, response);

        }
        catch(Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "companyDashboard.jsp")
                    .forward(request, response);
        }
    }
}