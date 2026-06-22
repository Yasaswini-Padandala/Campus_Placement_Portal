<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.org.cp.model.Job"%>

<%
List<Job> jobs =
(List<Job>)request.getAttribute("jobs");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Posted Jobs</title>

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
    background:linear-gradient(45deg,#1e293b,#334155);
    color:white;
    padding:18px;
    font-size:15px;
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

.action-buttons{
    display:flex;
    justify-content:center;
    gap:10px;
    flex-wrap:wrap;
}

.delete-btn{
    border:none;
    padding:10px 18px;
    border-radius:10px;
    cursor:pointer;
    color:white;
    font-weight:600;
    background:linear-gradient(45deg,#dc2626,#ef4444);
    transition:.3s;
}

.delete-btn:hover{
    transform:translateY(-2px);
}

.update-btn{
    border:none;
    padding:10px 18px;
    border-radius:10px;
    cursor:pointer;
    color:white;
    font-weight:600;
    background:linear-gradient(45deg,#2563eb,#60a5fa);
    transition:.3s;
}

.update-btn:hover{
    transform:translateY(-2px);
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
    transition:.3s;
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
}

.footer-btn{
    text-align:center;
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

    <h1>💼 My Posted Jobs</h1>

</div>

<div class="container">

<%
if(jobs != null && !jobs.isEmpty()){
%>

<div class="table-container">

<table>

<tr>

<th>Job ID</th>
<th>Job Title</th>
<th>Description</th>
<th>CGPA</th>
<th>Skills</th>
<th>Last Date</th>
<th>Actions</th>

</tr>

<%
for(Job job : jobs){
%>

<tr>

<td><%=job.getJobId()%></td>

<td>
<%=job.getJobTitle()%>
</td>

<td>
<%=job.getDescription()%>
</td>

<td>
<%=job.getRequiredCGPA()%>
</td>

<td>
<%=job.getSkills()%>
</td>

<td>
<%=job.getLastDate()%>
</td>

<td>

<div class="action-buttons">

<form action="deleteJob"
      method="post">

<input type="hidden"
       name="jobId"
       value="<%=job.getJobId()%>">

<button type="submit"
        class="delete-btn">

🗑 Delete

</button>

</form>

<form action="editJob"
      >

<input type="hidden"
       name="jobId"
       value="<%=job.getJobId()%>">

<button type="submit"
        class="update-btn">

✏ Edit

</button>

</form>

</div>

</td>

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

📭 No Jobs Posted Yet

</div>

<%
}
%>

<div class="footer-btn">

<a href="companyDashboard.jsp"
   class="back-btn">

⬅ Back To Dashboard

</a>

</div>

</div>
<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>
</body>
</html>