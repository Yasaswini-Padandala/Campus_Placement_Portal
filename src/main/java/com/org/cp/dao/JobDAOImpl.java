package com.org.cp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.cp.model.Job;
import com.org.cp.utility.DBConnection;

public class JobDAOImpl implements JobDAO {

    private Connection con;

    public JobDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public int addJob(Job job) {

        int result = 0;

        String query =
                "INSERT INTO Job(companyId,jobTitle,description,"
              + "requiredCGPA,skills,lastDate) "
              + "VALUES(?,?,?,?,?,?)";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, job.getCompanyId());
            pstmt.setString(2, job.getJobTitle());
            pstmt.setString(3, job.getDescription());
            pstmt.setDouble(4, job.getRequiredCGPA());
            pstmt.setString(5, job.getSkills());
            pstmt.setDate(6, job.getLastDate());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Add Job Error : "
                            + e.getMessage());
        }

        return result;
    }

    @Override
    public Job getJobById(int jobId) {

        Job job = null;

        String query =
                "SELECT * FROM Job WHERE jobId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, jobId);

            ResultSet rs =
                    pstmt.executeQuery();

            if (rs.next()) {

                job = extractJob(rs);
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Get Job Error : "
                            + e.getMessage());
        }

        return job;
    }

    @Override
    public List<Job> getAllJobs() {

        List<Job> jobs =
                new ArrayList<>();

        String query =
                "SELECT * FROM Job";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                jobs.add(
                        extractJob(rs));
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Get All Jobs Error : "
                            + e.getMessage());
        }

        return jobs;
    }

    @Override
    public List<Job> getJobsByCompanyId(int companyId) {

        List<Job> jobs =
                new ArrayList<>();

        String query =
                "SELECT * FROM Job "
              + "WHERE companyId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, companyId);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                jobs.add(
                        extractJob(rs));
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Company Jobs Error : "
                            + e.getMessage());
        }

        return jobs;
    }

    @Override
    public int updateJob(Job job) {

        int result = 0;

        String query =
                "UPDATE Job "
              + "SET companyId=?,jobTitle=?,"
              + "description=?,requiredCGPA=?,"
              + "skills=?,lastDate=? "
              + "WHERE jobId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, job.getCompanyId());
            pstmt.setString(2, job.getJobTitle());
            pstmt.setString(3, job.getDescription());
            pstmt.setDouble(4, job.getRequiredCGPA());
            pstmt.setString(5, job.getSkills());
            pstmt.setDate(6, job.getLastDate());
            pstmt.setInt(7, job.getJobId());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Update Job Error : "
                            + e.getMessage());
        }

        return result;
    }

    @Override
    public int deleteJob(int jobId) {

        int result = 0;

        String query =
                "DELETE FROM Job "
              + "WHERE jobId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, jobId);

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Delete Job Error : "
                            + e.getMessage());
        }

        return result;
    }

    private Job extractJob(ResultSet rs)
            throws SQLException {

        Job job = new Job();

        job.setJobId(
                rs.getInt("jobId"));

        job.setCompanyId(
                rs.getInt("companyId"));

        job.setJobTitle(
                rs.getString("jobTitle"));

        job.setDescription(
                rs.getString("description"));

        job.setRequiredCGPA(
                rs.getDouble("requiredCGPA"));

        job.setSkills(
                rs.getString("skills"));

        job.setLastDate(
                rs.getDate("lastDate"));

        return job;
    }
}