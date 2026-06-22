<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.org.cp.model.Job"%>

<%
Job job = (Job)request.getAttribute("job");

if(job == null){
    response.sendRedirect("viewCompanyJobs");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Job</title>
<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:30px;
    background:linear-gradient(
    135deg,
    #0f172a,
    #1e293b,
    #334155);
}

.container{

    width:750px;

    background:
    rgba(255,255,255,0.08);

    backdrop-filter:blur(20px);

    border:1px solid
    rgba(255,255,255,0.1);

    border-radius:25px;

    padding:40px;

    box-shadow:
    0 15px 40px
    rgba(0,0,0,0.3);
}

h1{

    text-align:center;

    color:white;

    font-size:34px;

    margin-bottom:30px;
}

.form-group{

    margin-bottom:22px;
}

label{

    display:block;

    margin-bottom:8px;

    color:#e2e8f0;

    font-weight:600;
}

input,
textarea{

    width:100%;

    padding:14px;

    border-radius:12px;

    border:1px solid
    rgba(255,255,255,0.15);

    background:
    rgba(255,255,255,0.08);

    color:white;

    font-size:15px;

    outline:none;
}

input::placeholder,
textarea::placeholder{

    color:#cbd5e1;
}

input:focus,
textarea:focus{

    border-color:#3b82f6;

    box-shadow:
    0 0 10px
    rgba(59,130,246,.4);
}

textarea{

    min-height:140px;

    resize:vertical;
}

.btn{

    width:100%;

    padding:15px;

    border:none;

    border-radius:12px;

    background:
    linear-gradient(
    45deg,
    #2563eb,
    #3b82f6);

    color:white;

    font-size:17px;

    font-weight:600;

    cursor:pointer;

    transition:.3s;
}

.btn:hover{

    transform:translateY(-3px);
}

.back-btn{

    display:block;

    text-align:center;

    margin-top:18px;

    text-decoration:none;

    color:#93c5fd;

    font-weight:600;
}

.back-btn:hover{

    color:white;
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
<div class="container">

<h1>Edit Job</h1>

<form action="updateJob" method="post">

<input type="hidden"
       name="jobId"
       value="<%=job.getJobId()%>">

<div class="form-group">

<label>Job Title</label>

<input type="text"
       name="jobTitle"
       value="<%=job.getJobTitle()%>"
       required>

</div>

<div class="form-group">

<label>Description</label>

<textarea name="description"
          required><%=job.getDescription()%></textarea>

</div>

<div class="form-group">

<label>Required CGPA</label>

<input type="number"
       step="0.01"
       name="requiredCGPA"
       value="<%=job.getRequiredCGPA()%>"
       required>

</div>

<div class="form-group">

<label>Skills</label>

<input type="text"
       name="skills"
       value="<%=job.getSkills()%>"
       required>

</div>

<div class="form-group">

<label>Last Date</label>

<input type="date"
       name="lastDate"
       value="<%=job.getLastDate()%>"
       required>

</div>

<button type="submit"
        class="btn">

Update Job

</button>

</form>

<a href="viewCompanyJobs"
   class="back-btn">

Back to My Jobs

</a>

</div>
<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>
</body>
</html>