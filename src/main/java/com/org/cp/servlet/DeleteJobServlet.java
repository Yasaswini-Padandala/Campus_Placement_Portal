package com.org.cp.servlet;

import java.io.IOException;

import com.org.cp.dao.JobDAO;
import com.org.cp.dao.JobDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteJob")
public class DeleteJobServlet extends HttpServlet {
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

        if(session == null ||
           session.getAttribute("admin") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        try {

            int jobId =
                    Integer.parseInt(
                            request.getParameter(
                                    "jobId"));

            int result =
                    jobDAO.deleteJob(jobId);

            if(result > 0) {

                response.sendRedirect(
                        "viewJobsAdmin");
            }
            else {

                request.setAttribute(
                        "error",
                        "Job Deletion Failed");

                request.getRequestDispatcher(
                        "viewJobsAdmin.jsp")
                        .forward(request,
                                 response);
            }

        }
        catch(Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "viewJobsAdmin.jsp")
                    .forward(request,
                             response);
        }
    }
}