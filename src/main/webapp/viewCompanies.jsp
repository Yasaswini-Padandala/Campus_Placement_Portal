<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.org.cp.model.Company"%>

<%
List<Company> companies =
(List<Company>)request.getAttribute("companies");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Companies</title>
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
    padding-bottom:30px;
}

.header{
    text-align:center;
    padding:30px;
    color:white;
}

.header h1{
    font-size:34px;
    font-weight:700;
    letter-spacing:1px;
}

.container{
    width:95%;
    margin:25px auto;
}

.table-container{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:20px;
    overflow:hidden;
    box-shadow:0 10px 30px rgba(0,0,0,0.25);
    border:1px solid rgba(255,255,255,0.1);
}

table{
    width:100%;
    border-collapse:collapse;
}

th{
    background:linear-gradient(45deg,#2563eb,#3b82f6);
    color:white;
    padding:18px;
    font-size:15px;
    font-weight:600;
}

td{
    padding:16px;
    text-align:center;
    color:#e2e8f0;
    border-bottom:1px solid rgba(255,255,255,0.08);
}

tr:hover{
    background:rgba(255,255,255,0.05);
}

.delete-btn{
    border:none;
    padding:10px 18px;
    border-radius:10px;
    cursor:pointer;
    color:white;
    font-weight:600;
    background:linear-gradient(45deg,#dc2626,#ef4444);
    transition:0.3s;
}

.delete-btn:hover{
    transform:translateY(-3px);
}

.back-btn{
    display:inline-block;
    margin-top:25px;
    text-decoration:none;
    color:white;
    padding:12px 24px;
    border-radius:10px;
    font-weight:600;
    background:linear-gradient(45deg,#475569,#64748b);
    transition:0.3s;
}

.back-btn:hover{
    transform:translateY(-3px);
}

.no-data{
    text-align:center;
    color:white;
    font-size:22px;
    padding:60px 20px;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:20px;
    border:1px solid rgba(255,255,255,0.1);
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

<div class="header">

<h1>Manage Companies</h1>

</div>


<%
if(companies != null && !companies.isEmpty()){
%>
<div class="table-container">

<table>

<tr>

<th>Company ID</th>

<th>Name</th>

<th>Email</th>

<th>Location</th>

<th>Action</th>

</tr>

<%
for(Company company : companies){
%>

<tr>

<td>
<%=company.getCompanyId()%>
</td>

<td>
<%=company.getCompanyName()%>
</td>

<td>
<%=company.getEmail()%>
</td>

<td>
<%=company.getLocation()%>
</td>

<td>

<form action="deleteCompany"
      method="post">

<input type="hidden"
       name="companyId"
       value="<%=company.getCompanyId()%>">

<button type="submit"
        class="delete-btn">

Delete

</button>

</form>

</td>

</tr>

<%
}
%>

</table>
</div>

<%
}
else{
%>

<div class="no-data">

<h2>No Companies Found</h2>

</div>

<%
}
%>

<a href="adminDashboard.jsp"
   class="back-btn">

Back To Dashboard

</a>

<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>

</body>
</html>