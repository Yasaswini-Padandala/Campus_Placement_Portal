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
<title>Available Jobs</title>

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
    width:90%;
    margin:30px auto;
}

/* TITLE */
.title{
    text-align:center;
    color:white;
    font-size:28px;
    margin-bottom:20px;
}

/* JOB CARD */
.job-card{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border:1px solid rgba(255,255,255,0.1);
    border-radius:20px;
    padding:25px;
    margin-bottom:20px;
    color:white;
    transition:0.3s;
}

.job-card:hover{
    transform:translateY(-5px);
}

.job-card h2{
    color:#60a5fa;
    margin-bottom:12px;
}

.job-card p{
    margin:6px 0;
    color:#e2e8f0;
}

/* BUTTON */
.apply-btn{
    margin-top:12px;
    background:linear-gradient(45deg,#16a34a,#22c55e);
    border:none;
    padding:12px 18px;
    border-radius:10px;
    color:white;
    cursor:pointer;
    font-weight:600;
}

.apply-btn:hover{
    transform:scale(1.05);
}

/* BACK BUTTON */
.back-btn{
    display:inline-block;
    margin-top:20px;
    text-decoration:none;
    background:#6b7280;
    color:white;
    padding:10px 15px;
    border-radius:8px;
}

/* EMPTY STATE */
.no-jobs{
    text-align:center;
    font-size:20px;
    color:white;
    margin-top:50px;
}

/* FOOTER */
.footer{
    background:#111827;
    color:white;
    text-align:center;
    padding:12px;
    margin-top:auto;
}

</style>

</head>

<body>

<div class="top-header">
    Campus Placement Portal Management System
</div>

<div class="page-wrapper">

<div class="title">Available Jobs</div>

<%
if(jobs != null && !jobs.isEmpty()){

for(Job job : jobs){
%>

<div class="job-card">

<h2><%=job.getJobTitle()%></h2>

<p><b>Job ID:</b> <%=job.getJobId()%></p>
<p><b>Description:</b> <%=job.getDescription()%></p>
<p><b>Required CGPA:</b> <%=job.getRequiredCGPA()%></p>
<p><b>Skills:</b> <%=job.getSkills()%></p>
<p><b>Last Date:</b> <%=job.getLastDate()%></p>

<form action="application" method="post">
<input type="hidden" name="jobId" value="<%=job.getJobId()%>">

<button type="submit" class="apply-btn">
    Apply Now
</button>
</form>

</div>

<%
}
}else{
%>

<div class="no-jobs">
    No Jobs Available
</div>

<%
}
%>

<a href="studentDashboard.jsp" class="back-btn">
    Back To Dashboard
</a>
</div>


<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>

</body>
</html>