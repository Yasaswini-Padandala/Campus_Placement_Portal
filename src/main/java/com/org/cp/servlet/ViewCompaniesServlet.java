package com.org.cp.servlet;

import java.io.IOException;
import java.util.List;

import com.org.cp.dao.CompanyDAO;
import com.org.cp.dao.CompanyDAOImpl;
import com.org.cp.model.Company;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewCompanies")
public class ViewCompaniesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	private CompanyDAO companyDAO;

    @Override
    public void init() throws ServletException {

        companyDAO = new CompanyDAOImpl();
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

            List<Company> companies =
                    companyDAO.getAllCompanies();

            request.setAttribute(
                    "companies",
                    companies);

            request.getRequestDispatcher(
                    "viewCompanies.jsp")
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