<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.org.cp.model.Student"%>

<%
Student student = (Student)session.getAttribute("student");

if(student == null){
response.sendRedirect("login.jsp");
return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>

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
    padding:30px;
}

/* CARD */
.profile-card{
    width:750px;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(18px);
    border:1px solid rgba(255,255,255,0.1);
    border-radius:25px;
    overflow:hidden;
    box-shadow:0 15px 35px rgba(0,0,0,0.35);
}

/* HEADER INSIDE CARD */
.card-header{
    background:linear-gradient(135deg,#2563eb,#3b82f6);
    color:white;
    text-align:center;
    padding:30px;
}

.card-header h1{
    font-size:28px;
}

/* CONTENT */
.content{
    padding:30px;
}

/* INFO BOX */
.info{
    background:rgba(255,255,255,0.08);
    border:1px solid rgba(255,255,255,0.1);
    color:white;
    padding:12px;
    border-radius:12px;
    margin-bottom:20px;
    text-align:center;
}

/* FORM */
.form-group{
    margin-bottom:18px;
}

label{
    display:block;
    margin-bottom:6px;
    color:#e2e8f0;
    font-weight:600;
}

input{
    width:100%;
    padding:14px;
    border-radius:12px;
    border:1px solid rgba(255,255,255,0.15);
    background:rgba(255,255,255,0.08);
    color:white;
    outline:none;
}

input::placeholder{
    color:#cbd5e1;
}

input:focus{
    border-color:#60a5fa;
    box-shadow:0 0 12px rgba(96,165,250,0.4);
}

/* BUTTON */
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
    font-weight:600;
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

<div class="profile-card">

<div class="card-header">
    <h1>Edit Student Profile</h1>
</div>

<div class="content">

<div class="info">
    <b>Student ID:</b> <%=student.getStudentId()%>
</div>

<form action="updateStudent" method="post">

<div class="form-group">
<label>Name</label>
<input type="text" name="name"
value="<%=student.getName()%>" required>
</div>

<div class="form-group">
<label>Email</label>
<input type="email" name="email"
value="<%=student.getEmail()%>" required>
</div>

<div class="form-group">
<label>CGPA</label>
<input type="number" step="0.01" min="0" max="10"
name="cgpa"
value="<%=student.getCgpa()%>" required>
</div>

<div class="form-group">
<label>Skills</label>
<input type="text" name="skills"
value="<%=student.getSkills()%>"
placeholder="Java, JSP, Servlet" required>
</div>

<div class="form-group">
<label>Resume Link</label>
<input type="url" name="resumeLink"
value="<%=student.getResumePath()==null ? "" : student.getResumePath()%>">
</div>

<button type="submit" class="btn">
    Update Profile
</button>

</form>

<a href="studentDashboard.jsp" class="back-btn">
    Back To Dashboard
</a>

</div>

</div>

</div>

<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>

</body>
</html>