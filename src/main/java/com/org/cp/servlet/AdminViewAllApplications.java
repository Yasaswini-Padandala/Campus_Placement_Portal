package com.org.cp.servlet;

import java.io.IOException;
import java.util.List;

import com.org.cp.dao.ApplicationDAO;
import com.org.cp.dao.ApplicationDAOImpl;
import com.org.cp.model.Application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewApplications")
public class AdminViewAllApplications extends HttpServlet {

private static final long serialVersionUID = 1L;

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

    List<Application> applications =
            applicationDAO.getAllApplications();

    request.setAttribute(
            "applications",
            applications);

    request.getRequestDispatcher(
            "viewApplications.jsp")
            .forward(request, response);
}


}
