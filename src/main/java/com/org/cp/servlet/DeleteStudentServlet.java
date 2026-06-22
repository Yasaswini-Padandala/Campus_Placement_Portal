package com.org.cp.servlet;

import java.io.IOException;

import com.org.cp.dao.StudentDAO;
import com.org.cp.dao.StudentDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {

        studentDAO = new StudentDAOImpl();
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

            int studentId =
                    Integer.parseInt(
                            request.getParameter(
                                    "studentId"));

            int result =
                    studentDAO.deleteStudent(
                            studentId);

            if(result > 0) {

                response.sendRedirect(
                        "viewStudents");
            }
            else {

                request.setAttribute(
                        "error",
                        "Student Deletion Failed");

                request.getRequestDispatcher(
                        "viewStudents.jsp")
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
                    "viewStudents.jsp")
                    .forward(request,
                             response);
        }
    }
}