package com.org.cp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.org.cp.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminDashboard")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null ||
            session.getAttribute("admin") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        try {

            Connection con =
                    DBConnection.getConnection();

            int totalStudents =
                    getCount(con, "Student");

            int totalCompanies =
                    getCount(con, "Company");

            int totalJobs =
                    getCount(con, "Job");

            int totalApplications =
                    getCount(con, "Application");

            session.setAttribute(
                    "totalStudents",
                    totalStudents);

            session.setAttribute(
                    "totalCompanies",
                    totalCompanies);

            session.setAttribute(
                    "totalJobs",
                    totalJobs);

            session.setAttribute(
                    "totalApplications",
                    totalApplications);
            
            request.getRequestDispatcher(
                    "adminDashboard.jsp")
                    .forward(request, response);

        }
        catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "adminDashboard.jsp")
                    .forward(request, response);
        }
    }

    private int getCount(Connection con,
                         String tableName) {

        int count = 0;

        try {

            String query =
                    "SELECT COUNT(*) FROM "
                    + tableName;

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            ResultSet rs =
                    pstmt.executeQuery();

            if (rs.next()) {

                count = rs.getInt(1);
            }

        }
        catch (Exception e) {

            System.out.println(
                    "Count Error : "
                    + e.getMessage());
        }

        return count;
    }
    
}