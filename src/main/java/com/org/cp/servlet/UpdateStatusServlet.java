package com.org.cp.servlet;

import java.io.IOException;

import com.org.cp.dao.ApplicationDAO;
import com.org.cp.dao.ApplicationDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {

    private ApplicationDAO applicationDAO;

    @Override
    public void init() throws ServletException {

        applicationDAO =
                new ApplicationDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int applicationId =
                    Integer.parseInt(
                            request.getParameter(
                                    "applicationId"));

            String status =
                    request.getParameter(
                            "status");

            int result =
                    applicationDAO
                    .updateApplicationStatus(
                            applicationId,
                            status);

            if(result > 0) {

                response.sendRedirect(
                        "viewApplicants");
            }
            else {

                request.setAttribute(
                        "error",
                        "Status Update Failed");

                request.getRequestDispatcher(
                        "viewApplicants.jsp")
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
                    "viewApplicants.jsp")
                    .forward(request,
                             response);
        }
    }
}