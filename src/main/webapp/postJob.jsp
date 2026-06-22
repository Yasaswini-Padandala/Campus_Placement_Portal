<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.org.cp.model.Company"%>

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
<title>Post Job</title>

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
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    color:white;
    padding:20px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    box-shadow:0 4px 15px rgba(0,0,0,0.2);
}

.navbar h2{
    font-size:26px;
}

.navbar a{
    text-decoration:none;
    color:white;
    background:linear-gradient(45deg,#ef4444,#dc2626);
    padding:12px 20px;
    border-radius:10px;
    font-weight:600;
    transition:.3s;
}

.navbar a:hover{
    transform:translateY(-2px);
}

.container{
    width:90%;
    max-width:800px;
    margin:40px auto;
}

.card{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    padding:35px;
    border-radius:20px;
    box-shadow:0 10px 30px rgba(0,0,0,0.25);
    border:1px solid rgba(255,255,255,0.1);
}

.card h2{
    text-align:center;
    margin-bottom:30px;
    color:white;
    font-size:30px;
}

.input-group{
    margin-bottom:20px;
}

.input-group label{
    display:block;
    margin-bottom:8px;
    font-weight:600;
    color:#dbeafe;
}

.input-group input,
.input-group textarea{
    width:100%;
    padding:14px;
    border-radius:12px;
    border:1px solid rgba(255,255,255,0.15);
    background:rgba(255,255,255,0.08);
    color:white;
    font-size:15px;
    outline:none;
}

.input-group input:focus,
.input-group textarea:focus{
    border-color:#60a5fa;
    box-shadow:0 0 12px rgba(96,165,250,0.4);
}

.input-group textarea{
    resize:vertical;
    min-height:140px;
}

.btn{
    width:100%;
    padding:15px;
    border:none;
    border-radius:12px;
    background:linear-gradient(45deg,#2563eb,#60a5fa);
    color:white;
    font-size:16px;
    font-weight:600;
    cursor:pointer;
    transition:.3s;
}

.btn:hover{
    transform:translateY(-3px);
}

.success{
    background:rgba(34,197,94,0.15);
    color:#86efac;
    padding:14px;
    border-radius:12px;
    margin-bottom:18px;
    text-align:center;
}

.error{
    background:rgba(239,68,68,0.15);
    color:#fca5a5;
    padding:14px;
    border-radius:12px;
    margin-bottom:18px;
    text-align:center;
}

.back-btn{
    display:inline-block;
    margin-top:20px;
    text-decoration:none;
    color:white;
    padding:12px 20px;
    border-radius:10px;
    background:linear-gradient(45deg,#475569,#64748b);
    transition:.3s;
}

.back-btn:hover{
    transform:translateY(-2px);
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

<h2>Post New Job</h2>

<a href="login?action=logout">
Logout
</a>

</div>

<div class="container">

<div class="card">

<h2>
Create Job Opening
</h2>

<%
String success =
(String)request.getAttribute("success");

String error =
(String)request.getAttribute("error");

if(success != null){
%>

<div class="success">
<%=success%>
</div>

<%
}

if(error != null){
%>

<div class="error">
<%=error%>
</div>

<%
}
%>

<form action="postJob" method="post">

<div class="input-group">

<label>Job Title</label>

<input type="text"
       name="jobTitle"
       required>

</div>

<div class="input-group">

<label>Job Description</label>

<textarea name="description"
          required></textarea>

</div>

<div class="input-group">

<label>Required CGPA</label>

<input type="number"
       step="0.01"
       min="0"
       max="10"
       name="requiredCGPA"
       required>

</div>

<div class="input-group">

<label>Required Skills</label>

<input type="text"
       name="skills"
       placeholder="Java, JDBC, Servlets, MySQL"
       required>

</div>

<div class="input-group">

<label>Application Last Date</label>

<input type="date"
       name="lastDate"
       required>

</div>

<button type="submit"
        class="btn">

Post Job

</button>

</form>

<a href="companyDashboard.jsp"
   class="back-btn">

Back To Dashboard

</a>

</div>

</div>
<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>
</body>
</html>