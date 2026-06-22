package com.org.cp.model;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private double cgpa;
    private String skills;
    private String resumePath;

    public Student() {
        super();
    }

    public Student(int studentId, String name, String email,
                   String password, String phone,
                   double cgpa, String skills,
                   String resumePath) {

        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.cgpa = cgpa;
        this.skills = skills;
        this.resumePath = resumePath;
    }

    public Student(String name, String email,
                   String password, String phone,
                   double cgpa, String skills,
                   String resumePath) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.cgpa = cgpa;
        this.skills = skills;
        this.resumePath = resumePath;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId
                + ", name=" + name
                + ", email=" + email
                + ", password=" + password
                + ", phone=" + phone
                + ", cgpa=" + cgpa
                + ", skills=" + skills
                + ", resumePath=" + resumePath
                + "]";
    }
}
