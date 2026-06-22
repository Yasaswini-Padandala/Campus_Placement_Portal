package com.org.cp.dao;

import java.util.List;

import com.org.cp.model.Company;

public interface CompanyDAO {

    int addCompany(Company company);

    Company login(String email,
                  String password);

    Company getCompanyById(int companyId);

    List<Company> getAllCompanies();

    int updateCompany(Company company);

    int deleteCompany(int companyId);

    boolean isEmailExists(String email);
}