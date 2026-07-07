
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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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

        String role =
                request.getParameter("role");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        try {

            if ("student".equalsIgnoreCase(role)) {

                Student student =
                        studentDAO.login(
                                email,
                                password);

                if (student != null) {

                    HttpSession session =
                            request.getSession();

                    session.setAttribute(
                            "student",
                            student);

                    request.getRequestDispatcher(
                            "studentDashboard.jsp")
                            .forward(request,
                                    response);
                }
                else {

                    request.setAttribute(
                            "error",
                            "Invalid Student Credentials");

                    request.getRequestDispatcher(
                            "login.jsp")
                            .forward(request,
                                    response);
                }
            }

            else if ("company".equalsIgnoreCase(role)) {

                Company company =
                        companyDAO.login(
                                email,
                                password);

                if (company != null) {

                    HttpSession session =
                            request.getSession();

                    session.setAttribute(
                            "company",
                            company);

                    response.sendRedirect(
                            "companyDashboard.jsp");
                }
                else {

                    request.setAttribute(
                            "error",
                            "Invalid Company Credentials");

                    request.getRequestDispatcher(
                            "login.jsp")
                            .forward(request,
                                    response);
                }
            }

            else if ("admin".equalsIgnoreCase(role)) {

                if (email.equals(
                        "admin@gmail.com")
                        &&
                    password.equals(
                        "admin123")) {

                    HttpSession session =
                            request.getSession();

                    session.setAttribute(
                            "admin",
                            email);
                    

                    response.sendRedirect(
                            "adminDashboard");
                }
                else {

                    request.setAttribute(
                            "error",
                            "Invalid Admin Credentials");

                    request.getRequestDispatcher(
                            "login.jsp")
                            .forward(request,
                                    response);
                }
            }

            else {

                request.setAttribute(
                        "error",
                        "Invalid Role");

                request.getRequestDispatcher(
                        "login.jsp")
                        .forward(request,
                                response);
            }

        }
        catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    "Login Failed : "
                            + e.getMessage());

            request.getRequestDispatcher(
                    "login.jsp")
                    .forward(request,
                            response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        if("logout".equals(action)) {

            HttpSession session =
                    request.getSession(false);

            if(session != null) {

                session.invalidate();
            }

            response.sendRedirect("login.jsp");
        }
    }
    
}
