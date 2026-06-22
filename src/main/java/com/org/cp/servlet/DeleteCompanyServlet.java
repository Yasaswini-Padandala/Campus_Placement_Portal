package com.org.cp.servlet;

import java.io.IOException;

import com.org.cp.dao.CompanyDAO;
import com.org.cp.dao.CompanyDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteCompany")
public class DeleteCompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CompanyDAO companyDAO;

    @Override
    public void init() throws ServletException {

        companyDAO = new CompanyDAOImpl();
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

            int companyId =
                    Integer.parseInt(
                            request.getParameter(
                                    "companyId"));

            int result =
                    companyDAO.deleteCompany(
                            companyId);

            if(result > 0) {

                response.sendRedirect(
                        "viewCompanies");
            }
            else {

                request.setAttribute(
                        "error",
                        "Company Deletion Failed");

                request.getRequestDispatcher(
                        "viewCompanies.jsp")
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
                    "viewCompanies.jsp")
                    .forward(request,
                             response);
        }
    }
}