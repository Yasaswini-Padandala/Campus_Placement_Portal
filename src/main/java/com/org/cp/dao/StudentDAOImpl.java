package com.org.cp.dao;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.cp.model.Student;
import com.org.cp.utility.DBConnection;

public class StudentDAOImpl implements StudentDAO {

	    private Connection con;

	    public StudentDAOImpl() {
	        con = DBConnection.getConnection();
	    }

	    @Override
	    public int addStudent(Student student) {

	        int result = 0;

	        String query =
	                "INSERT INTO Student(name,email,password,phone,cgpa,skills,resumePath) "
	              + "VALUES(?,?,?,?,?,?,?)";

	        try {

	            PreparedStatement pstmt =
	                    con.prepareStatement(query);

	            pstmt.setString(1, student.getName());
	            pstmt.setString(2, student.getEmail());
	            pstmt.setString(3, student.getPassword());
	            pstmt.setString(4, student.getPhone());
	            pstmt.setDouble(5, student.getCgpa());
	            pstmt.setString(6, student.getSkills());
	            pstmt.setString(7, student.getResumePath());

	            result = pstmt.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(
	                    "Error while adding student : "
	                            + e.getMessage());

	        }

	        return result;
	    }

	    @Override
	    public Student login(String email,
	                         String password) {

	        Student student = null;

	        String query =
	                "SELECT * FROM Student "
	              + "WHERE email=? AND password=?";

	        try {

	            PreparedStatement pstmt =
	                    con.prepareStatement(query);

	            pstmt.setString(1, email);
	            pstmt.setString(2, password);

	            ResultSet rs =
	                    pstmt.executeQuery();

	            if (rs.next()) {

	                student = extractStudent(rs);
	            }

	        } catch (SQLException e) {

	            System.out.println(
	                    "Login Error : "
	                            + e.getMessage());
	        }

	        return student;
	    }

	    @Override
	    public Student getStudentById(int studentId) {

	        Student student = null;

	        String query =
	                "SELECT * FROM Student "
	              + "WHERE studentId=?";

	        try {

	            PreparedStatement pstmt =
	                    con.prepareStatement(query);

	            pstmt.setInt(1, studentId);

	            ResultSet rs =
	                    pstmt.executeQuery();

	            if (rs.next()) {

	                student = extractStudent(rs);
	            }

	        } catch (SQLException e) {

	            System.out.println(
	                    "Error fetching student : "
	                            + e.getMessage());
	        }

	        return student;
	    }

	    @Override
	    public List<Student> getAllStudents() {

	        List<Student> students =
	                new ArrayList<>();

	        String query =
	                "SELECT * FROM Student";

	        try {

	            PreparedStatement pstmt =
	                    con.prepareStatement(query);

	            ResultSet rs =
	                    pstmt.executeQuery();

	            while (rs.next()) {

	                students.add(
	                        extractStudent(rs));
	            }

	        } catch (SQLException e) {

	            System.out.println(
	                    "Error fetching students : "
	                            + e.getMessage());
	        }

	        return students;
	    }

	    @Override
	    public int updateStudent(Student student) {

	        int result = 0;

	        String query =
	                "UPDATE Student "
	              + "SET name=?,email=?,password=?,"
	              + "phone=?,cgpa=?,skills=? "
	              + "WHERE studentId=?";

	        try {

	            PreparedStatement pstmt =
	                    con.prepareStatement(query);

	            pstmt.setString(1, student.getName());
	            pstmt.setString(2, student.getEmail());
	            pstmt.setString(3, student.getPassword());
	            pstmt.setString(4, student.getPhone());
	            pstmt.setDouble(5, student.getCgpa());
	            pstmt.setString(6, student.getSkills());
	            pstmt.setInt(7, student.getStudentId());

	            result = pstmt.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(
	                    "Update Error : "
	                            + e.getMessage());
	        }

	        return result;
	    }

	    @Override
	    public int deleteStudent(int studentId) {

	        int result = 0;

	        String query =
	                "DELETE FROM Student "
	              + "WHERE studentId=?";

	        try {

	            PreparedStatement pstmt =
	                    con.prepareStatement(query);

	            pstmt.setInt(1, studentId);

	            result = pstmt.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(
	                    "Delete Error : "
	                            + e.getMessage());
	        }

	        return result;
	    }

	    @Override
	    public int updateResume(int studentId,
	                            String resumePath) {

	        int result = 0;

	        String query =
	                "UPDATE Student "
	              + "SET resumePath=? "
	              + "WHERE studentId=?";

	        try {

	            PreparedStatement pstmt =
	                    con.prepareStatement(query);

	            pstmt.setString(1, resumePath);
	            pstmt.setInt(2, studentId);

	            result = pstmt.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(
	                    "Resume Update Error : "
	                            + e.getMessage());
	        }

	        return result;
	    }

	    @Override
	    public boolean isEmailExists(String email) {

	        boolean exists = false;

	        String query =
	                "SELECT email FROM Student "
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

	        } catch (SQLException e) {

	            System.out.println(
	                    "Email Check Error : "
	                            + e.getMessage());
	        }

	        return exists;
	    }

	    private Student extractStudent(
	            ResultSet rs)
	            throws SQLException {

	        Student student =
	                new Student();

	        student.setStudentId(
	                rs.getInt("studentId"));

	        student.setName(
	                rs.getString("name"));

	        student.setEmail(
	                rs.getString("email"));

	        student.setPassword(
	                rs.getString("password"));

	        student.setPhone(
	                rs.getString("phone"));

	        student.setCgpa(
	                rs.getDouble("cgpa"));

	        student.setSkills(
	                rs.getString("skills"));

	        student.setResumePath(
	                rs.getString("resumePath"));

	        return student;
	    }
	}
