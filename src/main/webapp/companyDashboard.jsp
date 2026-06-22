
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.org.cp.model.Company" %>

<%
Company company =
(Company)session.getAttribute("company");

if(company == null){

    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company Dashboard</title>
<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    min-height:100vh;
    background:linear-gradient(135deg,#0f172a,#1e293b,#334155);
}

.navbar{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:20px 40px;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
}

.navbar h2{
    color:white;
}

.logout-btn{
    text-decoration:none;
    color:white;
    background:#ef4444;
    padding:12px 22px;
    border-radius:10px;
    font-weight:bold;
}

.container{
    width:92%;
    margin:30px auto;
}

.profile-card{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    padding:35px;
    border-radius:25px;
    color:white;
    margin-bottom:30px;
}

.profile-card h2{
    margin-bottom:15px;
    font-size:30px;
}

.profile-card p{
    margin-bottom:10px;
    color:#cbd5e1;
}

.footer{

    text-align:center;

    color:#94a3b8;

    padding:25px;

    border-top:
    1px solid rgba(255,255,255,0.08);
}
.grid{
    display:grid;
    grid-template-columns:
    repeat(auto-fit,minmax(280px,1fr));
    gap:25px;
}

.card{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:25px;
    padding:35px;
    text-align:center;
    color:white;
    transition:.4s;
}

.card:hover{
    transform:translateY(-10px);
}

.card h3{
    margin-bottom:15px;
    font-size:24px;
}

.card p{
    color:#cbd5e1;
    margin-bottom:25px;
}

.card a{
    text-decoration:none;
    background:linear-gradient(45deg,#2563eb,#3b82f6);
    color:white;
    padding:12px 24px;
    border-radius:10px;
    display:inline-block;
    font-weight:bold;
}
html, body {
    height: 100%;
    margin: 0;
    display: flex;
    flex-direction: column;
}

/* This makes content take full height */
body {
    min-height: 100vh;
}

/* Main page wrapper (IMPORTANT) */
.container {
    flex: 1;
}

/* Top title bar */
.top-header {
    background: linear-gradient(135deg, #1f2937, #2563eb);
    color: white;
    text-align: center;
    padding: 18px;
    font-size: 20px;
    font-weight: bold;
    letter-spacing: 1px;
}

/* Sticky footer */
.footer {
    background: #111827;
    color: white;
    text-align: center;
    padding: 12px;
    margin-top: auto;
    font-size: 14px;
}
</style>
</head>


<body>
<div class="top-header">
    Campus Placement Portal Management System
</div>
<div class="navbar">

<h2>Company Dashboard</h2>

<a href="login?action=logout"
   class="logout-btn">

   Logout

</a>

</div>

<div class="container">

<div class="profile-card">

<h2>
Welcome,
<%=company.getCompanyName()%>
</h2>

<p>
<b>Email :</b>
<%=company.getEmail()%>
</p>

<p>
<b>Location :</b>
<%=company.getLocation()%>
</p>

</div>

<div class="grid">

<div class="card">

<h3>Post Job</h3>

<p>
Create a new job opening.
</p>

<a href="postJob.jsp">

Post Job

</a>

</div>

<div class="card">

<h3>My Jobs</h3>

<p>
View all posted jobs.
</p>

<a href="viewCompanyJobs">

View Jobs

</a>

</div>

<div class="card">

<h3>Applicants</h3>

<p>
Manage student applications.
</p>

<a href="viewApplicants">

View Applicants

</a>

</div>

<div class="card">

<h3>Company Profile</h3>

<p>
Update company information.
</p>

<a href="editCompany.jsp">

Edit Profile

</a>

</div>

</div>

</div>

<div class="footer">

© 2026 Campus Placement Portal | Company Dashboard

</div>
</body>
</html>
