
package com.org.cp.servlet;

import java.io.IOException;

import com.org.cp.dao.CompanyDAO;
import com.org.cp.dao.CompanyDAOImpl;
import com.org.cp.dao.StudentDAO;
import com.org.cp.dao.StudentDAOImpl;
import com.org.cp.model.Company;
import com.org.cp.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private StudentDAO studentDAO;
    private CompanyDAO companyDAO;

    @Override
    public void init() throws ServletException {

        studentDAO = new StudentDAOImpl();
        companyDAO = new CompanyDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String role = request.getParameter("role");

        try {

            if ("student".equalsIgnoreCase(role)) {

                registerStudent(request, response);
            }
            else if ("company".equalsIgnoreCase(role)) {

                registerCompany(request, response);
            }
            else {

                request.setAttribute(
                        "error",
                        "Invalid Role Selected");

                request.getRequestDispatcher(
                        "register.jsp")
                        .forward(request, response);
            }

        }
        catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    "Registration Failed : "
                            + e.getMessage());

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);
        }
    }

    private void registerStudent(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        String phone =
                request.getParameter("phone");

        String cgpaStr =
                request.getParameter("cgpa");

        String skills =
                request.getParameter("skills");

        if (name == null || name.trim().isEmpty()) {

            request.setAttribute(
                    "error",
                    "Name is required");

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);

            return;
        }

        if (email == null || email.trim().isEmpty()) {

            request.setAttribute(
                    "error",
                    "Email is required");

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);

            return;
        }

        if (studentDAO.isEmailExists(email)) {

            request.setAttribute(
                    "error",
                    "Email already exists");

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);

            return;
        }

        double cgpa =
                Double.parseDouble(cgpaStr);

        Student student =
                new Student();

        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        student.setPhone(phone);
        student.setCgpa(cgpa);
        student.setSkills(skills);
        student.setResumePath(null);

        int result =
                studentDAO.addStudent(student);

        if (result > 0) {

            request.setAttribute(
                    "success",
                    "Student Registered Successfully");

            request.getRequestDispatcher(
                    "login.jsp")
                    .forward(request, response);
        }
        else {

            request.setAttribute(
                    "error",
                    "Student Registration Failed");

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);
        }
    }

    private void registerCompany(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String companyName =
                request.getParameter(
                        "companyName");

        String email =
                request.getParameter(
                        "email");

        String password =
                request.getParameter(
                        "password");

        String location =
                request.getParameter(
                        "location");

        if (companyName == null
                || companyName.trim().isEmpty()) {

            request.setAttribute(
                    "error",
                    "Company Name is required");

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);

            return;
        }

        if (companyDAO.isEmailExists(email)) {

            request.setAttribute(
                    "error",
                    "Email already exists");

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);

            return;
        }

        Company company =
                new Company();

        company.setCompanyName(
                companyName);

        company.setEmail(email);

        company.setPassword(password);

        company.setLocation(location);

        int result =
                companyDAO.addCompany(
                        company);

        if (result > 0) {

            request.setAttribute(
                    "success",
                    "Company Registered Successfully");

            request.getRequestDispatcher(
                    "login.jsp")
                    .forward(request, response);
        }
        else {

            request.setAttribute(
                    "error",
                    "Company Registration Failed");

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);
        }
    }
}

