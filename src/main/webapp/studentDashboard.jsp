<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.org.cp.model.Student" %>

<%
Student student =
(Student)session.getAttribute("student");

if(student == null){

    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>

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
    box-shadow:0 4px 15px rgba(0,0,0,0.2);
}

.navbar h2{
    color:white;
    font-size:28px;
}

.logout-btn{
    background:#ef4444;
    padding:12px 20px;
    border-radius:10px;
}

.logout-btn a{
    text-decoration:none;
    color:white;
    font-weight:600;
}

.container{
    width:92%;
    margin:30px auto;
}

.profile-card{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:20px;
    padding:30px;
    margin-bottom:30px;
    color:white;
    box-shadow:0 8px 25px rgba(0,0,0,0.2);
}

.profile-card h3{
    margin-bottom:20px;
    font-size:28px;
    color:#60a5fa;
}

.profile-card p{
    margin-bottom:12px;
    color:#dbeafe;
    font-size:15px;
}

.menu-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(280px,1fr));
    gap:25px;
    align-items:stretch;
}

.card{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:20px;
    padding:30px;
    text-align:center;
    transition:.3s;

    display:flex;
    flex-direction:column;
    justify-content:space-between;

    min-height:250px;

    box-shadow:0 8px 25px rgba(0,0,0,0.2);
}

.card:hover{
    transform:translateY(-8px);
}

.card h3{
    color:white;
    margin-bottom:15px;
    font-size:22px;
}

.card p{
    color:#dbeafe;
    margin-bottom:20px;
    line-height:1.6;
}

.card a{
    display:inline-block;
    text-decoration:none;
    padding:12px 22px;
    border-radius:10px;
    color:white;
    font-weight:600;
    background:linear-gradient(45deg,#2563eb,#60a5fa);
    transition:.3s;
}

.card a:hover{
    transform:scale(1.05);
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

    <h2>🎓 Student Dashboard</h2>

    <span class="logout-btn">
        <a href="login?action=logout">
            Logout
        </a>
    </span>

</div>

<div class="container">

    <div class="profile-card">

        <h3>
            Welcome, <%=student.getName()%>
        </h3>

        <p>
            <b>Email :</b>
            <%=student.getEmail()%>
        </p>

        <p>
            <b>Phone :</b>
            <%=student.getPhone()%>
        </p>

        <p>
            <b>CGPA :</b>
            <%=student.getCgpa()%>
        </p>

        <p>
            <b>Skills :</b>
            <%=student.getSkills()%>
        </p>

    </div>

    <div class="menu-grid">

        <div class="card">

            <h3>💼 Available Jobs</h3>

            <p>
                View all active job openings and apply for opportunities.
            </p>

            <a href="job?action=viewAllJobs">
                View Jobs
            </a>

        </div>

        <div class="card">

            <h3>📄 My Applications</h3>

            <p>
                Track all jobs you have applied for and check application status.
            </p>

            <a href="myApplications">
                View Applications
            </a>

        </div>

        <div class="card">

            <h3>📤 Upload Resume</h3>

            <p>
                Upload your latest resume to improve your profile visibility.
            </p>

            <a href="uploadResume.jsp">
                Upload Resume
            </a>

        </div>

        <div class="card">

            <h3>👤 Edit Profile</h3>

            <p>
                Update your personal information, skills and academic details.
            </p>

            <a href="editStudent.jsp">
                Edit Profile
            </a>

        </div>

    </div>

</div>
<div class="footer">
    © 2026 Campus Placement Portal | All Rights Reserved
</div>
</body>
</html>