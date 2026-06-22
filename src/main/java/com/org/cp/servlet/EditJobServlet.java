package com.org.cp.servlet;

import java.io.IOException;

import com.org.cp.dao.JobDAO;
import com.org.cp.dao.JobDAOImpl;
import com.org.cp.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editJob")
public class EditJobServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private JobDAO jobDAO;

    @Override
    public void init() {

        jobDAO = new JobDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int jobId =
                Integer.parseInt(
                        request.getParameter("jobId"));

        Job job =
                jobDAO.getJobById(jobId);

        request.setAttribute("job", job);

        request.getRequestDispatcher(
                "editJob.jsp")
                .forward(request, response);
    }
}