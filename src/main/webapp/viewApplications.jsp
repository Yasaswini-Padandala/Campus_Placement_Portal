<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.org.cp.model.Application"%>

<%
List<Application> applications =
(List<Application>) request.getAttribute("applications");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Applications</title>

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

.header{
    text-align:center;
    padding:30px;
    color:white;
}

.header h1{
    font-size:34px;
    font-weight:700;
}

.container{
    width:95%;
    margin:20px auto;
}

.table-container{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:20px;
    overflow:hidden;
    border:1px solid rgba(255,255,255,0.1);
    box-shadow:0 10px 30px rgba(0,0,0,0.25);
}

table{
    width:100%;
    border-collapse:collapse;
}

th{
    background:linear-gradient(45deg,#111827,#1f2937);
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

.status{
    padding:6px 12px;
    border-radius:8px;
    font-weight:600;
    display:inline-block;
}

.applied{
    background:#1d4ed8;
    color:white;
}

.selected{
    background:#16a34a;
    color:white;
}

.rejected{
    background:#dc2626;
    color:white;
}

.pending{
    background:#f59e0b;
    color:white;
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

.back-btn{
    display:inline-block;
    margin-top:25px;
    text-decoration:none;
    padding:12px 24px;
    border-radius:10px;
    color:white;
    font-weight:600;
    background:linear-gradient(45deg,#475569,#64748b);
    transition:0.3s;
}

.back-btn:hover{
    transform:translateY(-3px);
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
    <h1>📄 All Applications</h1>
</div>

<div class="container">

<%
if(applications != null && !applications.isEmpty()){
%>

<div class="table-container">

<table>

<tr>
    <th>Application ID</th>
    <th>Student ID</th>
    <th>Job ID</th>
    <th>Status</th>
    <th>Applied Date</th>
</tr>

<%
for(Application app : applications){
%>

<tr>

<td><%=app.getApplicationId()%></td>
<td><%=app.getStudentId()%></td>
<td><%=app.getJobId()%></td>

<td>
    <span class="status <%=app.getStatus().toLowerCase()%>">
        <%=app.getStatus()%>
    </span>
</td>

<td><%=app.getAppliedDate()%></td>

</tr>

<%
}
%>

</table>

</div>

<%
}else{
%>

<div class="no-data">
    📭 No Applications Found
</div>

<%
}
%>

<a href="adminDashboard.jsp" class="back-btn">
    ⬅ Back To Dashboard
</a>

</div>

<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>
</body>
</html>