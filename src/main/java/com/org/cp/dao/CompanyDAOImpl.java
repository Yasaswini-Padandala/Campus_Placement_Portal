package com.org.cp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.cp.model.Company;
import com.org.cp.utility.DBConnection;

public class CompanyDAOImpl implements CompanyDAO {

    private Connection con;

    public CompanyDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public int addCompany(Company company) {

        int result = 0;

        String query =
                "INSERT INTO Company(companyName,email,password,location) "
              + "VALUES(?,?,?,?)";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setString(1,
                    company.getCompanyName());

            pstmt.setString(2,
                    company.getEmail());

            pstmt.setString(3,
                    company.getPassword());

            pstmt.setString(4,
                    company.getLocation());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Error Adding Company : "
                            + e.getMessage());
        }

        return result;
    }

    @Override
    public Company login(String email,
                         String password) {

        Company company = null;

        String query =
                "SELECT * FROM Company "
              + "WHERE email=? AND password=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs =
                    pstmt.executeQuery();

            if (rs.next()) {

                company = extractCompany(rs);
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Company Login Error : "
                            + e.getMessage());
        }

        return company;
    }

    @Override
    public Company getCompanyById(int companyId) {

        Company company = null;

        String query =
                "SELECT * FROM Company "
              + "WHERE companyId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, companyId);

            ResultSet rs =
                    pstmt.executeQuery();

            if (rs.next()) {

                company = extractCompany(rs);
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Fetch Company Error : "
                            + e.getMessage());
        }

        return company;
    }

    @Override
    public List<Company> getAllCompanies() {

        List<Company> companies =
                new ArrayList<>();

        String query =
                "SELECT * FROM Company";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                companies.add(
                        extractCompany(rs));
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Fetch Companies Error : "
                            + e.getMessage());
        }

        return companies;
    }

    @Override
    public int updateCompany(Company company) {

        int result = 0;

        String query =
                "UPDATE Company "
              + "SET companyName=?,email=?,"
              + "password=?,location=? "
              + "WHERE companyId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setString(1,
                    company.getCompanyName());

            pstmt.setString(2,
                    company.getEmail());

            pstmt.setString(3,
                    company.getPassword());

            pstmt.setString(4,
                    company.getLocation());

            pstmt.setInt(5,
                    company.getCompanyId());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Update Company Error : "
                            + e.getMessage());
        }

        return result;
    }

    @Override
    public int deleteCompany(int companyId) {

        int result = 0;

        String query =
                "DELETE FROM Company "
              + "WHERE companyId=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(1, companyId);

            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {

            System.out.println(
                    "Delete Company Error : "
                            + e.getMessage());
        }

        return result;
    }

    @Override
    public boolean isEmailExists(String email) {

        boolean exists = false;

        String query =
                "SELECT email FROM Company "
              + "WHERE email=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setString(1, email);

            ResultSet rs =
                    pstmt.executeQuery();

            if (rs.next()) {

                exists = true;
            }

        }
        catch (SQLException e) {

            System.out.println(
                    "Email Check Error : "
                            + e.getMessage());
        }

        return exists;
    }

    private Company extractCompany(
            ResultSet rs)
            throws SQLException {

        Company company =
                new Company();

        company.setCompanyId(
                rs.getInt("companyId"));

        company.setCompanyName(
                rs.getString("companyName"));

        company.setEmail(
                rs.getString("email"));

        company.setPassword(
                rs.getString("password"));

        company.setLocation(
                rs.getString("location"));

        return company;
    }
}