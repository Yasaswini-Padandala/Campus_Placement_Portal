package com.org.cp.model;

public class Company {

    private int companyId;
    private String companyName;
    private String email;
    private String password;
    private String location;

    public Company() {
        super();
    }

    public Company(int companyId,
                   String companyName,
                   String email,
                   String password,
                   String location) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    public Company(String companyName,
                   String email,
                   String password,
                   String location) {

        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company [companyId=" + companyId
                + ", companyName=" + companyName
                + ", email=" + email
                + ", password=" + password
                + ", location=" + location
                + "]";
    }
}