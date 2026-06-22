package com.org.cp.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/myApplications")
public class MyApplicationsServlet extends HttpServlet {

    private ApplicationDAO applicationDAO;

    @Override
    public void init() {

        applicationDAO =
                new ApplicationDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("student") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        Student student =
                (Student)session.getAttribute(
                        "student");

        List<Application> applications =
                applicationDAO.getApplicationsByStudentId(
                        student.getStudentId());

        request.setAttribute(
                "applications",
                applications);

        request.getRequestDispatcher(
                "myApplications.jsp")
                .forward(request,
                         response);
    }
}