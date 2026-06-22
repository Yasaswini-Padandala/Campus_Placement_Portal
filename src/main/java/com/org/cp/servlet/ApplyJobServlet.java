package com.org.cp.servlet;

import java.io.IOException;
import java.sql.Date;

import com.org.cp.dao.ApplicationDAO;
import com.org.cp.dao.ApplicationDAOImpl;
import com.org.cp.model.Application;
import com.org.cp.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/application")
public class ApplyJobServlet extends HttpServlet {

    private ApplicationDAO applicationDAO;

    @Override
    public void init() throws ServletException {

        applicationDAO = new ApplicationDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("student") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        try {

            Student student =
                    (Student) session.getAttribute(
                            "student");

            int jobId =
                    Integer.parseInt(
                            request.getParameter(
                                    "jobId"));

            Application application =
                    new Application();

            application.setStudentId(
                    student.getStudentId());

            application.setJobId(
                    jobId);

            application.setAppliedDate(
                    new Date(
                            System.currentTimeMillis()));

            application.setStatus(
                    "Applied");

            int result =
                    applicationDAO.addApplication(
                            application);

            if(result > 0) {

                request.setAttribute(
                        "success",
                        "Application Submitted Successfully");

            } else {

                request.setAttribute(
                        "error",
                        "Application Failed");
            }

            response.sendRedirect(
                    "job?action=viewAllJobs");

        }
        catch(Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "viewAllJobs.jsp")
                    .forward(request,
                             response);
        }
    }
}