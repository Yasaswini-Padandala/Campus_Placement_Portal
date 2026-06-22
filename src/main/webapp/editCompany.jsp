<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.org.cp.model.Company"%>

<%
Company company =
(Company) session.getAttribute("company");

if(company == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Company Profile</title>

<style>

/* RESET */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

html, body{
    height:100%;
}

body{
    min-height:100vh;
    display:flex;
    flex-direction:column;
    background:linear-gradient(135deg,#0f172a,#1e293b,#334155);
}

/* HEADER */
.top-header{
    background:linear-gradient(135deg,#1f2937,#2563eb);
    color:white;
    text-align:center;
    padding:18px;
    font-size:20px;
    font-weight:bold;
}

/* PAGE WRAPPER */
.page-wrapper{
    flex:1;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:25px;
}

/* CARD */
.card{
    width:100%;
    max-width:600px;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:20px;
    padding:35px;
    box-shadow:0 10px 30px rgba(0,0,0,0.25);
    border:1px solid rgba(255,255,255,0.1);
    color:white;
}

/* TITLE */
.card h2{
    text-align:center;
    margin-bottom:20px;
    font-size:28px;
}

/* INFO */
.info{
    background:rgba(255,255,255,0.1);
    padding:12px;
    border-radius:10px;
    margin-bottom:18px;
    font-size:14px;
    text-align:center;
}

/* INPUTS */
.input-group{
    margin-bottom:15px;
}

label{
    display:block;
    margin-bottom:6px;
    font-weight:600;
    color:#e2e8f0;
}

input{
    width:100%;
    padding:14px;
    border:none;
    border-radius:10px;
    outline:none;
    font-size:15px;
    background:rgba(255,255,255,0.1);
    color:white;
}

input:focus{
    box-shadow:0 0 0 2px #3b82f6;
}

/* BUTTON */
.btn{
    width:100%;
    padding:14px;
    border:none;
    border-radius:10px;
    background:linear-gradient(45deg,#2563eb,#60a5fa);
    color:white;
    font-size:16px;
    font-weight:600;
    cursor:pointer;
    transition:0.3s;
}

.btn:hover{
    transform:translateY(-3px);
}

/* BACK */
.back-btn{
    display:block;
    text-align:center;
    margin-top:15px;
    color:#93c5fd;
    text-decoration:none;
}

.back-btn:hover{
    color:white;
}

/* FOOTER */
.footer{
    background:#111827;
    color:white;
    text-align:center;
    padding:12px;
    font-size:14px;
    margin-top:auto;
}

</style>

</head>

<body>

<div class="top-header">
    Campus Placement Portal Management System
</div>

<div class="page-wrapper">

<div class="card">

<h2>🏢 Edit Company Profile</h2>

<div class="info">
    Update your company details carefully.
</div>

<form action="updateCompany" method="post">

<input type="hidden" name="companyId"
       value="<%=company.getCompanyId()%>">

<div class="input-group">
    <label>Company Name</label>
    <input type="text" name="companyName"
           value="<%=company.getCompanyName()%>" required>
</div>

<div class="input-group">
    <label>Email</label>
    <input type="email" name="email"
           value="<%=company.getEmail()%>" required>
</div>

<div class="input-group">
    <label>Location</label>
    <input type="text" name="location"
           value="<%=company.getLocation()%>" required>
</div>

<div class="input-group">
    <label>Password</label>
    <input type="password" name="password"
           value="<%=company.getPassword()%>" required>
</div>

<button type="submit" class="btn">
    Update Profile
</button>

</form>

<a href="companyDashboard.jsp" class="back-btn">
    ← Back to Dashboard
</a>

</div>

</div>

<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>

</body>
</html>