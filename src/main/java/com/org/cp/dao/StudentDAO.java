package com.org.cp.dao;
import java.util.List;

import com.org.cp.model.Student;

public interface StudentDAO {

    // Register Student
    int addStudent(Student student);

    // Login
    Student login(String email, String password);

    // Get Student By ID
    Student getStudentById(int studentId);

    // Get All Students
    List<Student> getAllStudents();

    // Update Student
    int updateStudent(Student student);

    // Delete Student
    int deleteStudent(int studentId);

    // Upload/Update Resume
    int updateResume(int studentId, String resumePath);

    // Check Email Exists
    boolean isEmailExists(String email);
}