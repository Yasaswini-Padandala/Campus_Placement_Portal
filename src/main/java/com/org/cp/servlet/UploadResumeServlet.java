package com.org.cp.servlet;

import java.io.IOException;

import com.org.cp.dao.StudentDAO;
import com.org.cp.dao.StudentDAOImpl;
import com.org.cp.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/uploadResume")
public class UploadResumeServlet extends HttpServlet {

    private StudentDAO studentDAO;

    @Override
    public void init() {

        studentDAO = new StudentDAOImpl();
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

        Student student =
                (Student) session.getAttribute("student");

        String resumeLink =
                request.getParameter("resumeLink");

        int result =
                studentDAO.updateResume(
                        student.getStudentId(),
                        resumeLink);

        if(result > 0) {

            response.sendRedirect(
                    "studentDashboard.jsp");
        }
        else {

            request.setAttribute(
                    "error",
                    "Resume Upload Failed");

            request.getRequestDispatcher(
                    "uploadResume.jsp")
                    .forward(request, response);
        }
    }
}