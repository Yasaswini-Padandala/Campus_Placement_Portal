package com.org.cp.servlet;

import java.io.IOException;
import java.util.List;

import com.org.cp.dao.StudentDAO;
import com.org.cp.dao.StudentDAOImpl;
import com.org.cp.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {

        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
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

            List<Student> students =
                    studentDAO.getAllStudents();

            request.setAttribute(
                    "students",
                    students);

            request.getRequestDispatcher(
                    "viewStudents.jsp")
                    .forward(request,
                             response);

        }
        catch(Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "adminDashboard.jsp")
                    .forward(request,
                             response);
        }
    }
}