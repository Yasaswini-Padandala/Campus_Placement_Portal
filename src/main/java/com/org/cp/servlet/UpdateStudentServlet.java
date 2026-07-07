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

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

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

        Student student =
                (Student) session.getAttribute("student");

        student.setName(
                request.getParameter("name"));

        student.setEmail(
                request.getParameter("email"));

        student.setCgpa(
                Double.parseDouble(
                        request.getParameter("cgpa")));

        student.setSkills(
                request.getParameter("skills"));
        student.setResumePath(request.getParameter("resumeLink"));

        int result =
                studentDAO.updateStudent(student);

        if(result > 0) {

            session.setAttribute(
                    "student",
                    student);

            response.sendRedirect(
                    "studentDashboard.jsp");
        }
        else {

            response.sendRedirect(
                    "editStudent.jsp");
        }
    }
}