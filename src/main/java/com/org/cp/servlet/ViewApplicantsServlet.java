package com.org.cp.servlet;

import java.io.IOException;
import java.util.List;

import com.org.cp.dao.ApplicationDAO;
import com.org.cp.dao.ApplicationDAOImpl;
import com.org.cp.model.Application;
import com.org.cp.model.Company;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewApplicants")
public class ViewApplicantsServlet extends HttpServlet {

    private ApplicationDAO applicationDAO;

    @Override
    public void init() throws ServletException {

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
           session.getAttribute("company") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        try {

            Company company =
                    (Company) session.getAttribute(
                            "company");

            List<Application> applications =
                    applicationDAO
                    .getApplicationsByCompanyId(
                            company.getCompanyId());

            request.setAttribute(
                    "applications",
                    applications);

            request.getRequestDispatcher(
                    "viewApplicants.jsp")
                    .forward(request,
                             response);

        }
        catch(Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "companyDashboard.jsp")
                    .forward(request,
                             response);
        }
    }
}