package com.org.cp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.cp.model.Application;
import com.org.cp.utility.DBConnection;

public class ApplicationDAOImpl implements ApplicationDAO {

    private Connection con;

    public ApplicationDAOImpl() {

        con = DBConnection.getConnection();
    }

    @Override
    public int addApplication(Application application) {

        int result = 0;

        String query =
                "INSERT INTO Application(studentId,jobId,appliedDate,status) "
                        + "VALUES(?,?,?,?)";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1,
                    application.getStudentId());

            pstmt.setInt(2,
                    application.getJobId());

            pstmt.setDate(3,
                    application.getAppliedDate());

            pstmt.setString(4,
                    application.getStatus());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Add Application Error : "
                            + e.getMessage());
        }

        return result;
    }

    @Override
    public Application getApplicationById(
            int applicationId) {

        Application application = null;

        String query =
                "SELECT * FROM Application "
                        + "WHERE applicationId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, applicationId);

            ResultSet rs =
                    pstmt.executeQuery();

            if (rs.next()) {

                application =
                        extractApplication(rs);
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Fetch Application Error : "
                            + e.getMessage());
        }

        return application;
    }

    @Override
    public List<Application> getAllApplications() {

        List<Application> applications =
                new ArrayList<>();

        String query =
                "SELECT * FROM Application";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                applications.add(
                        extractApplication(rs));
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Fetch Applications Error : "
                            + e.getMessage());
        }

        return applications;
    }

    @Override
    public List<Application>
    getApplicationsByStudentId(
            int studentId) {

        List<Application> applications =
                new ArrayList<>();

        String query =
                "SELECT * FROM Application "
                        + "WHERE studentId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, studentId);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                applications.add(
                        extractApplication(rs));
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Student Applications Error : "
                            + e.getMessage());
        }

        return applications;
    }

    @Override
    public List<Application>
    getApplicationsByJobId(
            int jobId) {

        List<Application> applications =
                new ArrayList<>();

        String query =
                "SELECT * FROM Application "
                        + "WHERE jobId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, jobId);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                applications.add(
                        extractApplication(rs));
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Job Applications Error : "
                            + e.getMessage());
        }

        return applications;
    }

    @Override
    public int updateStatus(
            int applicationId,
            String status) {

        int result = 0;

        String query =
                "UPDATE Application "
                        + "SET status=? "
                        + "WHERE applicationId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setString(1, status);

            pstmt.setInt(2, applicationId);

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Update Status Error : "
                            + e.getMessage());
        }

        return result;
    }

    @Override
    public int deleteApplication(
            int applicationId) {

        int result = 0;

        String query =
                "DELETE FROM Application "
                        + "WHERE applicationId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, applicationId);

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Delete Application Error : "
                            + e.getMessage());
        }

        return result;
    }

    private Application extractApplication(
            ResultSet rs)
            throws SQLException {

        Application application =
                new Application();

        application.setApplicationId(
                rs.getInt("applicationId"));

        application.setStudentId(
                rs.getInt("studentId"));

        application.setJobId(
                rs.getInt("jobId"));

        application.setAppliedDate(
                rs.getDate("appliedDate"));

        application.setStatus(
                rs.getString("status"));

        return application;
    }
    
    
    
    
    
    
    @Override
    public List<Application> getApplicationsByCompanyId(
            int companyId) {

        List<Application> list =
                new ArrayList<>();

        String query =
                "SELECT a.* FROM Application a "
              + "JOIN Job j "
              + "ON a.jobId=j.jobId "
              + "WHERE j.companyId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, companyId);

            ResultSet rs =
                    pstmt.executeQuery();

            while(rs.next()) {

                Application app =
                        new Application();

                app.setApplicationId(
                        rs.getInt(
                                "applicationId"));

                app.setStudentId(
                        rs.getInt(
                                "studentId"));

                app.setJobId(
                        rs.getInt(
                                "jobId"));

                app.setAppliedDate(
                        rs.getDate(
                                "appliedDate"));

                app.setStatus(
                        rs.getString(
                                "status"));

                list.add(app);
            }

        }
        catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    
    
    @Override
    public int updateApplicationStatus(
            int applicationId,
            String status) {

        int result = 0;

        String query =
                "UPDATE Application "
              + "SET status=? "
              + "WHERE applicationId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setString(
                    1,
                    status);

            pstmt.setInt(
                    2,
                    applicationId);

            result =
                    pstmt.executeUpdate();

        }
        catch(Exception e) {

            e.printStackTrace();
        }

        return result;
    }
}